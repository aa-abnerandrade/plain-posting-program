package com.application.controller;

import com.application.domain.Post;
import com.application.domain.User;
import com.application.dto.UserDTO;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/find-all-users")
  public ResponseEntity<List<UserDTO>> findAllUsers() {
    List<User> response = userService.findAll();
    List<UserDTO> usersDTO = response.stream().map(UserDTO::new).toList();
    return ResponseEntity.ok().body(usersDTO);
  }

  @GetMapping("/find-user-{id}")
  public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
    User response = userService.findById(id);
    UserDTO userDTO = new UserDTO(response);
    return ResponseEntity.ok().body(userDTO);
  }

  @PostMapping("/create-user")
  public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
    User newUser = userDTO.fromDtoToUserEntity(userDTO);
    newUser = userService.insert(newUser);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/delete-user-{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/update-user-{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
    User paramUser = userDTO.fromDtoToUserEntity(userDTO);
    paramUser.setId(id);
    User updatedUser = userService.update(paramUser);
    UserDTO updatedUserDTO = new UserDTO(updatedUser);
    return ResponseEntity.ok().body(updatedUserDTO);
  }

  @GetMapping("/find-posts-by-user-{id}")
  public ResponseEntity<List<Post>> findPostsByUserId(@PathVariable String id) {
    User responseUser = userService.findById(id);
    List<Post> responsePostsFromUser = responseUser.getPosts();
    return ResponseEntity.ok().body(responsePostsFromUser);
  }
}
