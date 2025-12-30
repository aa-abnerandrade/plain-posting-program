package com.application.domain;

import com.application.dto.AuthorDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "post")
public class Post implements Serializable {
  @Serial
  private  static final long serialVersionUID = 1L;

  @Id
  private String id;

  private String title;

  private String body;

  private Date createdAt;

  private AuthorDTO author;


  public Post() {

  }
  public Post(String id, String title, String body, Date createdAt, AuthorDTO author) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.createdAt = createdAt;
    this.author = author;
  }

}
