package com.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CommentDTO implements Serializable {
  @Serial
  private  static final long serialVersionUID = 1L;
  
  private String text;
  private Date date;
  private AuthorDTO author;

  public CommentDTO() {

  }

  public CommentDTO(String text, Date date, AuthorDTO author) {
    this.text = text;
    this.date = date;
    this.author = author;
  }
}
