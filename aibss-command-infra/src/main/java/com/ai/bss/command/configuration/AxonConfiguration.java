package com.ai.bss.command.configuration;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandHandlerInterceptor;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.CommandGatewayFactoryBean;
import org.axonframework.commandhandling.interceptors.BeanValidationInterceptor;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.ClusteringEventBus;
import org.axonframework.eventhandling.DefaultClusterSelector;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventBusTerminal;
import org.axonframework.eventhandling.SimpleCluster;
import org.axonframework.eventhandling.amqp.spring.ListenerContainerLifecycleManager;
import org.axonframework.eventhandling.amqp.spring.SpringAMQPConsumerConfiguration;
import org.axonframework.eventhandling.amqp.spring.SpringAMQPTerminal;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerBeanPostProcessor;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.jdbc.EventSqlSchema;
import org.axonframework.eventstore.jdbc.GenericEventSqlSchema;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.axonframework.saga.repository.jdbc.HsqlSagaSqlSchema;
import org.axonframework.saga.repository.jdbc.SagaSqlSchema;
import org.axonframework.saga.spring.SpringResourceInjector;
import org.axonframework.serializer.json.JacksonSerializer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.command.policy.PolicyCheckInterceptor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Created by ben on 23/02/16.
 */
@Configuration
@AnnotationDriven
public class AxonConfiguration {
	
    private static final String AMQP_CONFIG_KEY = "AMQP.Config";
    @Autowired
    public ConnectionFactory connectionFactory;

    @Autowired
    public RabbitTransactionManager transactionManager;

    @Value("${spring.application.queue}")
    private String queueName;

    @Value("${spring.application.exchange}")
    private String exchangeName;

    @Value("${spring.application.mongodatabaseName}")
    private String mongoDatabaseName;

    @Value("${spring.application.eventsCollectionName}")
    private String eventsCollectionName;
    
    @Value("${spring.application.snapshotCollectionName}")
    private String snapshotCollectionName;

    @Value("${spring.application.mongo.host}")
    private String mongoHost;
    
    @Value("${spring.application.mongo.port}")
    private int mongoPort;
    
    

/*    @Bean
    XStreamSerializer xmlSerializer() {
        return new XStreamSerializer();
    }*/

    @Bean
    JacksonSerializer axonJsonSerializer() {
        return new JacksonSerializer();
    }

    @Bean
    ListenerContainerLifecycleManager listenerContainerLifecycleManager() {
        ListenerContainerLifecycleManager mgr = new ListenerContainerLifecycleManager();
        mgr.setConnectionFactory(connectionFactory);
        return mgr;
    }

    @Bean
    SpringAMQPConsumerConfiguration springAMQPConsumerConfiguration() {
        SpringAMQPConsumerConfiguration cfg = new SpringAMQPConsumerConfiguration();
        cfg.setTransactionManager(transactionManager);
        cfg.setQueueName(queueName);
        cfg.setTxSize(10);
        return cfg;
    }


    @Bean
    SimpleCluster simpleCluster() {
        SimpleCluster cluster = new SimpleCluster(queueName);
        cluster.getMetaData().setProperty(AMQP_CONFIG_KEY, springAMQPConsumerConfiguration());
        return cluster;
    }

    @Bean
    EventBusTerminal terminal() {
        SpringAMQPTerminal terminal = new SpringAMQPTerminal();
        terminal.setConnectionFactory(connectionFactory);
        terminal.setExchangeName(exchangeName);
        terminal.setDurable(true);
        terminal.setTransactional(true);
        terminal.setSerializer(axonJsonSerializer());
        //terminal.setSerializer(xmlSerializer());
        terminal.setListenerContainerLifecycleManager(listenerContainerLifecycleManager());
        return terminal;
    }

    @Bean
    EventBus eventBus() {
        return new ClusteringEventBus(new DefaultClusterSelector(simpleCluster()), terminal());
    }

    @Bean(name = "axonMongoTemplate")
    MongoTemplate axonMongoTemplate() throws Exception{
        MongoTemplate template = new DefaultMongoTemplate(mongo(),
                mongoDatabaseName, eventsCollectionName, snapshotCollectionName, null, null);
        return template;
    }

    @Bean
    EventStore eventStore() throws Exception{
        //MongoEventStore eventStore = new MongoEventStore(xmlSerializer(), axonMongoTemplate());
        MongoEventStore eventStore = new MongoEventStore(axonJsonSerializer(), axonMongoTemplate());
        return eventStore;
    }    

    @Bean
    CommandBus commandBus() {
        SimpleCommandBus commandBus = new SimpleCommandBus();
        List dispacthList=new ArrayList<>();
        dispacthList.add(beanValidationInterceptor());
        commandBus.setDispatchInterceptors(dispacthList);
        List<CommandHandlerInterceptor> commandInterList=new ArrayList<>();
        commandInterList.add(policyCheckInterceptor());
        commandBus.setHandlerInterceptors(commandInterList);
        return commandBus;
    }
    
    @Bean
    BeanValidationInterceptor beanValidationInterceptor(){
    	return new BeanValidationInterceptor();
    }
    
    @Bean
    PolicyCheckInterceptor policyCheckInterceptor(){
    	return new PolicyCheckInterceptor();
    }

    @Bean
    CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean() {
        CommandGatewayFactoryBean<CommandGateway> factory = new CommandGatewayFactoryBean<CommandGateway>();
        factory.setCommandBus(commandBus());
        return factory;
    }

    /**
     * This method allows Axon to automatically find your @EventHandler's
     *
     * @return
     */
    @Bean
    AnnotationEventListenerBeanPostProcessor eventListenerBeanPostProcessor() {
        AnnotationEventListenerBeanPostProcessor proc = new AnnotationEventListenerBeanPostProcessor();
        proc.setEventBus(eventBus());
        return proc;
    }

    /**
     * This method allows Axon to automatically find your @CommandHandler's
     *
     * @return
     */
    @Bean
    AnnotationCommandHandlerBeanPostProcessor commandHandlerBeanPostProcessor() {
        AnnotationCommandHandlerBeanPostProcessor proc = new AnnotationCommandHandlerBeanPostProcessor();
        proc.setCommandBus(commandBus());
        return proc;
    }
        
    
    @Bean
    EventSqlSchema eventSqlSchema(){
    	EventSqlSchema eventSqlSchema=new GenericEventSqlSchema<>();
    	return eventSqlSchema;
    }
    
    @Bean
    SagaSqlSchema sagaSqlSchema(){
    	SagaSqlSchema sagaSqlSchema=new HsqlSagaSqlSchema();
    	return sagaSqlSchema;
    }

    @Bean
    SpringResourceInjector springResourceInjector(){
    	return new SpringResourceInjector();
    }
    
    @Bean
    Mongo mongo() throws Exception {
    	return new MongoClient(mongoHost,mongoPort);
    }

}
