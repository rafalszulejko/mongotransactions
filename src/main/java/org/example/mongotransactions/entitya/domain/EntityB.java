package org.example.mongotransactions.entitya.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("b")
class EntityB {
  @Id private String id;
  private String entityAId;
}
