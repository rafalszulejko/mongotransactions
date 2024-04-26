package org.example.mongotransactions;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableMongoRepositories()
@EnableTransactionManagement
class ApplicationConfiguration extends AbstractMongoClientConfiguration {
  @Value("${mongodb.host:localhost}")
  private String mongoHost;

  @Override
  protected String getDatabaseName() {
    return "core";
  }

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create(String.format("mongodb://%s:27017", mongoHost));
  }

  @Bean
  public MongoClientFactoryBean mongo() {
    MongoClientFactoryBean mongo = new MongoClientFactoryBean();
    mongo.setHost(mongoHost);
    return mongo;
  }

  @Bean
  public MongoTemplate mongoTemplate(MongoClient mongoClient) {
    return new MongoTemplate(mongoClient, "core");
  }

  @Bean
  MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }
}
