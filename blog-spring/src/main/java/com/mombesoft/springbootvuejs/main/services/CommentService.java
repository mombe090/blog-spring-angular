package com.mombesoft.springbootvuejs.main.services;

import com.mombesoft.springbootvuejs.main.entities.Comment;
import com.mombesoft.springbootvuejs.main.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentService;

    @Autowired
    public CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {

        return this.commentService.save(comment);
    }

}
