package org.example.mongotransactions.entitya.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EntityAMongoRepository extends MongoRepository<EntityA, String>, EntityARepository {}
