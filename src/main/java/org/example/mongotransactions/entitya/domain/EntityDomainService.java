package org.example.mongotransactions.entitya.domain;

import org.springframework.transaction.annotation.Transactional;

public class EntityDomainService {

  private final EntityARepository repository;
  private final EntityBRepository entityBRepository;

  EntityDomainService(EntityARepository repository, EntityBRepository entityBRepository) {
    this.repository = repository;
    this.entityBRepository = entityBRepository;
  }

  public EntityA register(EntityA arg) {
    return repository.save(arg);
  }

  public EntityA get(String id) {
    return repository.findById(id).orElseThrow();
  }

  @Transactional
  public void transactionalAdd(String id1, String id2) {
    repository.save(EntityA.builder().id(id1).build());
    fail();
    repository.save(EntityA.builder().id(id2).build());
  }

  private void fail() {
    throw new RuntimeException();
  }
}
