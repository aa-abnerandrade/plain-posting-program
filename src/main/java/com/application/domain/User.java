package com.application.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "user")
@EqualsAndHashCode
@Getter
@Setter
public class User implements Serializable {

  @Id
  private String id;
  private String name;
  private String email;


  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
}
