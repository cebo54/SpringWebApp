package com.springproje.Services;

import com.springproje.Repos.PostRepository;
import com.springproje.Requests.PostCreateRequest;
import com.springproje.Requests.PostUpdateRequest;
import com.springproje.Responses.LikeResponse;
import com.springproje.Responses.PostResponse;
import com.springproje.entities.Post;
import com.springproje.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;
    private LikeService likeService;

    public PostService(PostRepository postRepository, UserService userService,LikeService likeService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    public void setLikeService(LikeService likeService){
        this.likeService=likeService;
    }

    public List<PostResponse> getAllPosts(Optional<Long>userId) {
        List<Post> list;
        if(userId.isPresent()){
            list =postRepository.findByUserId(userId.get());
        }
        list=postRepository.findAll();
        return list.stream().map(p -> {
            List <LikeResponse> likes=likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
           return new PostResponse(p,likes);}).collect(Collectors.toList());
    }

    public Post saveOnePost(PostCreateRequest newPostRequest) {
        User user=userService.getOneUser(newPostRequest.getUserId());
        if(user==null)
            return null;
        Post toSave= new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }


    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);

    }

    public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post=postRepository.findById(postId);
        if(post.isPresent()){
            Post foundPost=post.get();
            foundPost.setTitle(updatePost.getTitle());
            foundPost.setText(updatePost.getText());
            postRepository.save(foundPost);
            return foundPost;
        }else{
            return null;}
    }

    public void deleteOnePost(Long postId) {

        postRepository.deleteById(postId);
    }

}
