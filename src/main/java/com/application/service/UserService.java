package com.application.service;

import com.application.domain.User;
import com.application.repository.UserRepository;
import com.application.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;


  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    Optional<User> responseUser = userRepository.findById(id);
    if (responseUser == null) {
      throw new ObjectNotFoundException("User not found with id: " + id);
    }
    return responseUser.get();
  }

}
