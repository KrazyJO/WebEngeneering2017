package com.micromata.webengineering.demo.post; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micromata.webengineering.demo.comment.Comment;
import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserRepository;
import com.micromata.webengineering.demo.user.UserService;

import java.util.UUID;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	public Iterable<Post> getPosts() 
	{
		return repository.findAll();
	}
	
    public void addPost(Post p)
    {
    	User author = userService.getCurrentUser();
    	p.setAuthor(author);
    	
    	repository.save(p);
    }
    
    public Post getPost(Long id)
    {
    	return repository.findOne(id);
    }
    
    public void deletePost(Long id)
    {
    	Post post = repository.findOne(id);
    	if (!post.getAuthor().equals(userService.getCurrentUser()))
    	{
    		throw new IllegalStateException("User not allowed to delete post");
    	}
    	repository.delete(id);
    }

	public void addComment(Long postId, Comment c) {
		Post p = repository.findOne(postId);
		
		if (p == null)
		{
			throw new IllegalArgumentException("Error on adding Comment to Post: post {" + postId + "} not found");
		}
		
		p.getComments().add(c);
		
		repository.save(p);
	}
}