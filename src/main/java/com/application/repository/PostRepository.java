package com.application.repository;

import com.application.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{ 'body': { $regex: ?0, $options: 'i' } }")
  List<Post> searchByTitleWithQuery(String title);

  List<Post> findByTitleContainingIgnoreCase(String text);

  @Query("{ $and: [ { createdAt: { $gte: ?1, $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> findByMultipleFields(String text, Date from, Date to);


}
