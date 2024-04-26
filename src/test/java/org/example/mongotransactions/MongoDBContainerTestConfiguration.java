package org.example.mongotransactions;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@EnableMongoRepositories
public class MongoDBContainerTestConfiguration {

  @Bean
  @ServiceConnection
  public MongoDBContainer mongoDBContainer() {
    return new MongoDBContainer(DockerImageName.parse("mongo:7.0")).withExposedPorts(27017);
  }
}
