package com.micromata.webengineering.demo.post;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

	// Note that everythin is case insensitive except for the Table (entity) name.
    @Query("SELECT p from Post p ORDER BY p.createdAt DESC")
    List<Post> findAll();
}
