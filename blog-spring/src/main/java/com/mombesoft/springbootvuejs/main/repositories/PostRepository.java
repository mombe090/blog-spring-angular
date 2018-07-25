package com.mombesoft.springbootvuejs.main.repositories;

import com.mombesoft.springbootvuejs.main.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    //List<Post> findAllByDeleted_atIsNull();

    @Query("SELECT p FROM Post p  WHERE p.deleted_at = NULL ORDER BY p.created_at DESC")
    List<Post> findAllByDeleted_atIsNull();
    Post findById(int id);
    Post findByTitleLike(String title);
    //Post findByEmail(String email);
}
