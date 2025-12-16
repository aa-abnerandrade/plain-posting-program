package com.application.config;

import com.application.domain.User;
import com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;


  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();
    User joao = new User(null, "Joao Silva", "joao@gmail.com");
    User maria = new User(null, "Maria Santos", "maria@outlook.com");
    User jose = new User(null, "Jose Souza", "jose@email.com");

    List<User> allUsers = Arrays.asList(joao, maria, jose);
    userRepository.saveAll(allUsers);
  }
}
