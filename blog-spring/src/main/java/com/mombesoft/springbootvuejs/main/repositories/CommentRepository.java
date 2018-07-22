package com.mombesoft.springbootvuejs.main.repositories;

import com.mombesoft.springbootvuejs.main.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
  List<Comment> findAll();
}
