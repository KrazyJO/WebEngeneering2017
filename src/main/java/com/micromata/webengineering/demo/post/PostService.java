package main.java.com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public Iterable<Post> getPosts() 
	{
		return repository.findAll();
	}
	
    public void addPost(Post p)
    {
    	repository.save(p);
    }
    
    public Post getPost(UUID id)
    {
    	return repository.findOne(id);
    }
    
    public void deletePost(UUID id)
    {
    	repository.delete(id);
    }
}