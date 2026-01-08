package com.application.controller;

import com.application.domain.Post;
import com.application.domain.User;
import com.application.dto.UserDTO;
import com.application.service.PostService;
import com.application.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/find-post-by-text-title")
  public ResponseEntity<List<Post>> findPostsByTitleContainingIgnoreCase(
          @RequestParam(value = "textParam") String textParam) {
    String textParamDecoded = URL.decodeParam(textParam);
    List<Post> responsePostsFounded = postService.findByTitleContainingIgnoreCase(textParamDecoded);
    return ResponseEntity.ok().body(responsePostsFounded);
  }
}
