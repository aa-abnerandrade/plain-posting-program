package com.application.service;

import com.application.domain.Post;
import com.application.repository.PostRepository;
import com.application.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public Post findById(String id) {
    Optional<Post> responsePost = postRepository.findById(id);
    if (responsePost == null || responsePost.isEmpty()) {
      throw new ObjectNotFoundException("Post not found with id: " + id);
    }
    return responsePost.get();
  }
}
