package main.java.com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private List<Post> posts = new LinkedList<>();

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public List<Post> getPosts() {
        return posts;
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(String title) {
        posts.add(new Post(title));
    }
    
    public Post getPostByGuid(UUID guid)
    {
    	//since there will be a database this should be good enough
    	Post rValue = null;
    	for (Post p : posts)
    	{
    		if (p.getGuid().equals(guid))
    		{
    			rValue = p;
    			break;
    		}
    	}
    	return rValue;
    }

    /**
     * deletes a single post
     * @param guid guid of the post
     */
	public void deletePost(UUID guid) {
		// since there will be a database this should work good enough
		for (Post p : posts)
		{
			if (p.getGuid().equals(guid))
			{
				posts.remove(p);
				break;
			}
		}
	}
}