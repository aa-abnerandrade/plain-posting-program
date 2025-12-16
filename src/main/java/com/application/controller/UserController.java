package com.application.controller;

import com.application.domain.User;
import com.application.dto.UserDTO;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all-users")
  public ResponseEntity<List<UserDTO>> findAllUsers() {
    List<User> response = userService.findAll();
    List<UserDTO> usersDTO = response.stream().map(UserDTO::new).toList();
    return ResponseEntity.ok().body(usersDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
    User response = userService.findById(id);
    UserDTO userDTO = new UserDTO(response);
    return ResponseEntity.ok().body(userDTO);
  }

}
