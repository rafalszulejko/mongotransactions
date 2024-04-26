package org.example.mongotransactions.entitya.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

interface EntityBRepository
    extends ListCrudRepository<EntityB, String>, ListPagingAndSortingRepository<EntityB, String> {}
