package com.ai.bss.mutitanent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Configuration
public class MultitenantConfiguration {

    @Autowired
    private DataSourceProperties properties;

    /**
     * Defines the data source for the application
     * @return
     */
    @Bean
    @ConfigurationProperties(
            prefix = "spring"
    )
    public DataSource dataSource() throws Exception{
    	ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(this.getClass().getClassLoader());
    	Resource[] resources = resolver.getResources("classpath*:/tenants/*.properties") ;
    	Map<Object,Object> resolvedDataSources = new HashMap<>();
    	for (Resource resource: resources){ 
    		Properties tenantProperties = new Properties();
            DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader());

            try {
                tenantProperties=PropertiesLoaderUtils.loadProperties(resource);

                String tenantId = tenantProperties.getProperty("name");
                System.out.println("==============tenantId is: "+tenantId);
                dataSourceBuilder.driverClassName(properties.getDriverClassName())
                        .url(tenantProperties.getProperty("datasource.url"))
                        .username(tenantProperties.getProperty("datasource.username"))
                        .password(tenantProperties.getProperty("datasource.password"));

                if(properties.getType() != null) {
                    dataSourceBuilder.type(properties.getType());
                }

                resolvedDataSources.put(tenantId, dataSourceBuilder.build());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
    	}
        // Create the final multi-tenant source.
        // It needs a default database to connect to.
        // Make sure that the default database is actually an empty tenant database.
        // Don't use that for a regular tenant if you want things to be safe!
        MultitenantDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        dataSource.setTargetDataSources(resolvedDataSources);

        // Call this to finalize the initialization of the data source.
        dataSource.afterPropertiesSet();

        return dataSource;
    }

    /**
     * Creates the default data source for the application
     * @return
     */
    private DataSource defaultDataSource() {
        DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader())
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword());

        if(properties.getType() != null) {
            dataSourceBuilder.type(properties.getType());
        }

        return dataSourceBuilder.build();
    }
}
