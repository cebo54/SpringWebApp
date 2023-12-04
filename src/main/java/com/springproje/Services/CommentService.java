package com.springproje.Services;

import com.springproje.Repos.CommentRepository;
import com.springproje.Requests.CommentCreateRequest;
import com.springproje.Requests.CommentUpdateRequest;
import com.springproje.entities.Comment;
import com.springproje.entities.Post;
import com.springproje.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent()&&postId.isPresent()){
            return commentRepository.findByuserIdAndPostId(userId.get(),postId.get());
        }else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    public Comment getOneComment(Long commentId) {

        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {
        User user = userService.getOneUser(request.getUserId());
        Post post=postService.getOnePost(request.getPostId());
        if(user!= null & post != null){
            Comment newComment=new Comment();
            newComment.setId(request.getId());
            newComment.setPost(post);
            newComment.setUser(user);
            newComment.setText(request.getText());
            return commentRepository.save(newComment);
        }else{
            return null;
        }
    }
    public Comment updateOneComment(Long commentId, CommentUpdateRequest newComment) {
        Optional<Comment> comment =commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(newComment.getText());
            return commentRepository.save(commentToUpdate);
        }else
            return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
