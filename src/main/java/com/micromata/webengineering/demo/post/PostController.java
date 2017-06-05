package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micromata.webengineering.demo.user.UserService;

//import main.java.com.micromata.webengeneering.demo.util.Util;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private Util util;
    @Autowired
    private UserService userService;
    
    private class PostAddReturn {
    	public String url;
    }

    @RequestMapping(value = "/api/post", method = RequestMethod.GET)
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }
    
    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.GET)
    public Post getSinglePost(@PathVariable(value = "id") Long id)
    {
    	System.out.println("guid: " + id);
    	return postService.getPost(id);
    }

    @RequestMapping(value = "/api/post/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addPost(@RequestBody Post post) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Option 2: validating the title length is driven by a technical (non-functional) requirement.
        // We choose this option to show the usage of ResponseEntity.
        if (post.getTitle() != null && post.getTitle().length() > Post.TITLE_LENGTH) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    	
    	postService.addPost(post);
        PostAddReturn rPost = new PostAddReturn();
        rPost.url = util.getCurrentHostAndPort(); 
        rPost.url += "/post/" + post.getId();
//        return rPost;
        return ResponseEntity.ok(rPost);
    }
    
    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable(value = "id") Long id)
    {
    	postService.deletePost(id);
    }
}
