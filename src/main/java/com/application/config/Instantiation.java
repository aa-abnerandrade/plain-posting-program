package com.application.config;

import com.application.domain.Post;
import com.application.domain.User;
import com.application.dto.AuthorDTO;
import com.application.dto.CommentDTO;
import com.application.repository.PostRepository;
import com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;


  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    postRepository.deleteAll();

    User joao = new User(null, "Joao Silva", "joao@gmail.com");
    User maria = new User(null, "Maria Santos", "maria@outlook.com");
    User jose = new User(null, "Jose Souza", "jose@email.com");
    List<User> allUsers = Arrays.asList(joao, maria, jose);
    userRepository.saveAll(allUsers);

    Post post1 = new Post(null, "Partiu viagem", "Vou viajar para São Paulo. Abraços!", sdf.parse("28/12/2025"), new AuthorDTO(maria));
    Post post2 = new Post(null, "Bom dia", "Acordei feliz hoje!", sdf.parse("20/12/2025"), new AuthorDTO(maria));
    CommentDTO comment1 = new CommentDTO("Boa viagem sister!", sdf.parse("29/12/2025"), new AuthorDTO(joao));
    CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("29/12/2025"), new AuthorDTO(jose));
    CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("21/12/2025"), new AuthorDTO(joao));
    post1.getComments().addAll(Arrays.asList(comment1, comment2));
    post2.getComments().add(comment3);
    List<Post> allPosts = Arrays.asList(post1, post2);
    postRepository.saveAll(allPosts);

    maria.getPosts().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }
}
