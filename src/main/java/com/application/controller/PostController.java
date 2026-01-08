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

  @GetMapping("/search-post-by-text-title")
  public ResponseEntity<List<Post>> searchPostsByTitleContainingIgnoreCase(
          @RequestParam(value = "titleParam") String titleParam) {
    String titleParamDecoded = URL.decodeParam(titleParam);
    List<Post> responsePostsFounded = postService.findByTitleContainingIgnoreCase(titleParamDecoded);
    return ResponseEntity.ok().body(responsePostsFounded);
  }

  @GetMapping("/search-post-by-text-body")
  public ResponseEntity<List<Post>> searchPostsByBodyWithQuery(
          @RequestParam(value = "bodyParam") String bodyParam) {
    String bodyParamDecoded = URL.decodeParam(bodyParam);
    List<Post> responsePostsFounded = postService.findByBodyWithQuery(bodyParamDecoded);
    return ResponseEntity.ok().body(responsePostsFounded);
  }
}
