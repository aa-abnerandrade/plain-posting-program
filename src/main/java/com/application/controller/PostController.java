package com.application.controller;

import com.application.domain.Post;
import com.application.domain.User;
import com.application.dto.UserDTO;
import com.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping("/find-post-{id}")
  public ResponseEntity<Post> findPostById(@PathVariable String id) {
    Post responsePost = postService.findById(id);
    return ResponseEntity.ok().body(responsePost);
  }
}
