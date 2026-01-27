package com.application.controller;

import com.application.domain.Post;
import com.application.domain.User;
import com.application.dto.UserDTO;
import com.application.service.PostService;
import com.application.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

  @GetMapping("/search-post-by-multiple-fields")
  public ResponseEntity<List<Post>> searchPostsByMultipleFields(
          @RequestParam(value = "textParam") String textParam,
          @RequestParam(value = "minDateParam", defaultValue = "") String minDateParam,
          @RequestParam(value = "maxDateParam", defaultValue = "") String maxDateParam) {
    String textParamDecoded = URL.decodeParam(textParam);
    Date minDate = URL.convertStringParamToDate(minDateParam, new Date(0L));
    Date maxDate = URL.convertStringParamToDate(maxDateParam, new Date());
    List<Post> responsePostsFounded = postService.findByMultipleFields(textParamDecoded, minDate, maxDate);
    return ResponseEntity.ok().body(responsePostsFounded);
  }
}


