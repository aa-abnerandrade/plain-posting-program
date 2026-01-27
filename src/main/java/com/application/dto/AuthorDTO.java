package com.application.dto;

import com.application.domain.User;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;

  public AuthorDTO() {

  }
  public AuthorDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }
}
