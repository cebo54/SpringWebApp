package com.springproje.Controllers;

import com.springproje.Requests.CommentCreateRequest;
import com.springproje.Requests.CommentUpdateRequest;
import com.springproje.Services.CommentService;
import com.springproje.entities.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
   private CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long>userId,@RequestParam Optional<Long>postId){
        return commentService.getAllComments(userId,postId);
    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request){
        return commentService.createOneComment(request);
    }
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneComment(commentId);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest newComment){
        return commentService.updateOneComment(commentId,newComment);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneComment(commentId);
    }
}
