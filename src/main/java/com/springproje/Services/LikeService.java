package com.springproje.Services;

import com.springproje.Repos.LikeRepository;
import com.springproje.Requests.LikeCreateRequest;
import com.springproje.Responses.LikeResponse;
import com.springproje.entities.Like;
import com.springproje.entities.Post;
import com.springproje.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if(userId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        }else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }


    public Like getOneLike(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createLike(LikeCreateRequest request) {
        User user=userService.getOneUser(request.getUserId());
        Post post=postService.getOnePost(request.getPostId());
        if(user!= null & post != null){
            Like likeToSave=new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        }else{
            return null;
        }
    }

    public void deleteOneLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
