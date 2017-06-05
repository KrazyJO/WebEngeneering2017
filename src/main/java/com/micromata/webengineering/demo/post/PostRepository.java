package com.micromata.webengineering.demo.post;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.micromata.webengineering.demo.comment.Comment;

public interface PostRepository extends CrudRepository<Post, Long> {

	// Note that everythin is case insensitive except for the Table (entity) name.
    @Query("SELECT p from Post p ORDER BY p.createdAt DESC")
    List<Post> findAll();
    
    @Query("SELECT p FROM Post p WHERE :comment MEMBER OF p.comments")
    Post findPostForComment(@Param("comment") Comment comment);
}
