package org.example.mongotransactions.entitya.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntityDomainService {

  private final EntityAMongoRepository repository;

  @Autowired
  EntityDomainService(EntityAMongoRepository repository) {
    this.repository = repository;
  }

  public EntityA register(EntityA arg) {
    return repository.save(arg);
  }

  public EntityA get(String id) {
    return repository.findById(id).orElseThrow();
  }

  public void transactionalAdd(String id1, String id2) {
    repository.save(EntityA.builder().id(id1).build());
    fail();
    repository.save(EntityA.builder().id(id2).build());
  }

  private void fail() {
    throw new RuntimeException();
  }
}
