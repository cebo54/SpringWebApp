package com.springproje.Repos;

import com.springproje.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
   List<Comment>findByuserIdAndPostId(Long userId , Long postId);


    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);
}
