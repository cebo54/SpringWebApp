package com.springproje.Controllers;

import com.springproje.Repos.PostRepository;
import com.springproje.Requests.PostCreateRequest;
import com.springproje.Requests.PostUpdateRequest;
import com.springproje.Responses.PostResponse;
import com.springproje.Services.PostService;
import com.springproje.entities.Post;
import com.springproje.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){

        return postService.getAllPosts(userId);
    }
    @PostMapping
    public Post newPost(@RequestBody PostCreateRequest newPostRequest){

        return postService.saveOnePost(newPostRequest);
    }
    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){

        return postService.getOnePost(postId);
    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId,@RequestBody PostUpdateRequest updatePost){
       return postService.updateOnePost(postId,updatePost);
    }
    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){

        postService.deleteOnePost(postId);
    }

}
