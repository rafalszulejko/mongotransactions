package org.example.mongotransactions.entitya.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EntityBMongoRepository extends MongoRepository<EntityB, String>, EntityBRepository {}
