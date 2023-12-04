package com.springproje.Controllers;

import com.springproje.Requests.LikeCreateRequest;
import com.springproje.Responses.LikeResponse;
import com.springproje.Services.LikeService;
import com.springproje.entities.Like;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {

        this.likeService = likeService;
    }
    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long>userId, @RequestParam Optional<Long>postId){

       return likeService.getAllLikes(userId,postId);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLike(likeId);
    }
    @PostMapping
    public Like createLike(@RequestBody LikeCreateRequest request){
        return likeService.createLike(request);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteOneLike(likeId);
    }

}
