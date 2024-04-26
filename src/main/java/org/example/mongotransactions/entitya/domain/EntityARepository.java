package org.example.mongotransactions.entitya.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

interface EntityARepository
    extends ListCrudRepository<EntityA, String>, ListPagingAndSortingRepository<EntityA, String> {}
