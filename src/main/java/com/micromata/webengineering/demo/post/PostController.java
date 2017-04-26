package main.java.com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    public List<Post> getPostList() {
        return postService.getPosts();
    }
    
    @RequestMapping("/post/{guid}")
    public Post getSinglePost(@PathVariable(value="guid") String guid)
    {
    	System.out.println("guid: " + guid);
		return postService.getPostByGuid(java.util.UUID.fromString(guid));
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost(@RequestParam("title") String title) {
        postService.addPost(title);
    }
    
    @RequestMapping(value = "/post/delete/{guid}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable(value="guid") String guid)
    {
    	postService.deletePost(java.util.UUID.fromString(guid));
    }
}
