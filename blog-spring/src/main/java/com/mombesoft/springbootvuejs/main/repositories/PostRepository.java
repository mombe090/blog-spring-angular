package com.mombesoft.springbootvuejs.main.repositories;

import com.mombesoft.springbootvuejs.main.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    //List<Post> findAllByDeleted_atIsNull();
    List<Post> findAll();
    Post findById(int id);
    Post findByTitleLike(String title);
    //Post findByEmail(String email);
}
