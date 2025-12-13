package com.application.controller;

import com.application.domain.User;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all-users")
  public ResponseEntity<List<User>> findAll() {
    List<User> response = userService.findAll();
    return ResponseEntity.ok().body(response);
  }

}
