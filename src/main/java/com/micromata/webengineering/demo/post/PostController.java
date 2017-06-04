package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    private class PostAddRetrun {
    	public String url;
    }

    @RequestMapping("/post")
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }
    
    @RequestMapping("/post/{guid}")
    public Post getSinglePost(@PathVariable(value="guid") String guid)
    {
    	System.out.println("guid: " + guid);
    	return postService.getPost(java.util.UUID.fromString(guid));
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public PostAddRetrun addPost(@RequestBody Post post) {
        postService.addPost(post);
        PostAddRetrun rPost = new PostAddRetrun();
        rPost.url = util.getCurrentHostAndPort(); 
        rPost.url += "/post/" + post.getGuid();
        return rPost;
    }
    
    @RequestMapping(value = "/post/delete/{guid}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable(value="guid") String guid)
    {
    	postService.deletePost(java.util.UUID.fromString(guid));
    }
}
