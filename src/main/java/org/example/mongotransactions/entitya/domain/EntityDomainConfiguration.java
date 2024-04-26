package org.example.mongotransactions.entitya.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class EntityDomainConfiguration {
  @Bean
  EntityDomainService domainService(
      EntityARepository entityARepository, EntityBRepository entityBRepository) {
    return new EntityDomainService(entityARepository, entityBRepository);
  }
}
