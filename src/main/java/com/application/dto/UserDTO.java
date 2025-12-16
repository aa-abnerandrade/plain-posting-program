package com.application.dto;

import com.application.domain.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Optional;

@Data
public class UserDTO {
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private String email;

  public UserDTO() {
  }
  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
  }

}
