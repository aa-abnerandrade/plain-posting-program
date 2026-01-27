package com.application.dto;

import com.application.domain.User;
import lombok.Data;

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

  public User fromDtoToUserEntity(UserDTO userDTO) {
    return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
  }

}
