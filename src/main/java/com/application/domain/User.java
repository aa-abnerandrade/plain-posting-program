package com.application.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "user")
public class User implements Serializable {

  @Id
  @Getter
  private String id;

  @Getter
  private String name;

  @Getter
  private String email;


  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

}
