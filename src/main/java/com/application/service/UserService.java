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
    if (responseUser == null || responseUser.isEmpty()) {
      throw new ObjectNotFoundException("User not found with id: " + id);
    }
    return responseUser.get();
  }

  public User insert(User user) {
    return userRepository.insert(user);
  }

  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }

  public User update(User newData) {
    User userData = findById(newData.getId());
    updateData(userData, newData);
    return userRepository.save(userData);
  }

  private void updateData(User userData, User newData) {
    userData.setName(newData.getName());
    userData.setEmail(newData.getEmail());
  }


  public User fromDtoToUser(User user) {
    return new User(user.getId(), user.getName(), user.getEmail());
  }
}
