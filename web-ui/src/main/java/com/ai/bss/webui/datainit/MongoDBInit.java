package com.ai.bss.webui.datainit;

import com.ai.bss.query.party.IndividualEntry;
import com.ai.bss.query.party.OrganizationEntry;
import com.ai.bss.query.party.PartyEntry;
import com.ai.bss.query.party.repositories.PartyQueryRepository;
import com.ai.bss.query.user.UserEntry;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.axonframework.saga.repository.mongo.MongoSagaRepository;
import org.axonframework.saga.repository.mongo.MongoTemplate;
import org.axonframework.saga.spring.SpringResourceInjector;
import org.axonframework.serializer.json.JacksonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
@Profile("mongodb")
public class MongoDBInit extends BaseDBInit {
    private final static Logger logger = LoggerFactory.getLogger(MongoDBInit.class);

    private org.axonframework.eventstore.mongo.MongoTemplate systemAxonMongo;
    private MongoEventStore eventStore;
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;
    private MongoTemplate systemAxonSagaMongo;
    private org.springframework.data.mongodb.core.MongoTemplate springTemplate;
    
    @Autowired
    private JacksonSerializer axonJsonSerializer;
    private org.axonframework.eventstore.mongo.MongoTemplate axonMongoTemplate;
    
    private SpringResourceInjector springResourceInjector;

//    @Autowired
//    public MongoDBInit(CommandBus commandBus,
//    					PartyQueryRepository partyQueryRepository,
//                       org.axonframework.eventstore.mongo.MongoTemplate systemMongo,
//                       MongoEventStore eventStore,
//                       org.springframework.data.mongodb.core.MongoTemplate mongoTemplate,
//                       MongoTemplate systemAxonSagaMongo,
////                       PortfolioQueryRepository portfolioRepository,
////                       OrderBookQueryRepository orderBookRepository, 
//                       org.springframework.data.mongodb.core.MongoTemplate springTemplate) {
//        super(commandBus,partyQueryRepository); 
////        		companyRepository, portfolioRepository, orderBookRepository);
//        this.systemAxonMongo = systemMongo;
//        this.eventStore = eventStore;
//        this.mongoTemplate = mongoTemplate;
//        this.systemAxonSagaMongo = systemAxonSagaMongo;
//        this.springTemplate = springTemplate;
//    }

    @Override
    public Set<String> obtainCollectionNames() {
        return springTemplate.getCollectionNames();
    }

    @Override
    public DataResults obtainCollection(String collectionName, int numItems, int start) {
        DBCursor dbCursor = springTemplate.getCollection(collectionName).find();
        List<DBObject> dbObjects = dbCursor.skip(start - 1).limit(numItems).toArray();

        List<Map> items = new ArrayList<>(dbCursor.length());
        for (DBObject dbObject : dbObjects) {
            items.add(dbObject.toMap());
        }

        int totalItems = dbCursor.count();

        return new DataResults(totalItems, items);
    }

    @Override
    public void createItemsIfNoUsersExist() {
        if (!mongoTemplate.collectionExists(UserEntry.class)) {
            createItems();
            logger.info("The database has been created and refreshed with some data.");
        }

    }

    @Override
    void initializeDB() {
        systemAxonMongo.domainEventCollection().drop();
        systemAxonMongo.snapshotEventCollection().drop();
        systemAxonSagaMongo.sagaCollection().drop();
        mongoTemplate.dropCollection(UserEntry.class);
        mongoTemplate.dropCollection(IndividualEntry.class);
        mongoTemplate.dropCollection(OrganizationEntry.class);
        mongoTemplate.dropCollection(PartyEntry.class);
    }

    @Override
    void additionalDBSteps() {
        eventStore.ensureIndexes();
    }
    
    @Bean
    EventStore eventStore() {
        //MongoEventStore eventStore = new MongoEventStore(xmlSerializer(), axonMongoTemplate());
        MongoEventStore eventStore = new MongoEventStore(axonJsonSerializer, axonMongoTemplate);
        return eventStore;
    }
    @Bean
    MongoSagaRepository sagaRepository(){
    	MongoSagaRepository sagaRepository=new MongoSagaRepository(systemAxonSagaMongo);
    	sagaRepository.setResourceInjector(springResourceInjector);
    	return sagaRepository;
    }
}
