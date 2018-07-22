package com.mombesoft.springbootvuejs.main.services;

import com.mombesoft.springbootvuejs.main.entities.Post;
import com.mombesoft.springbootvuejs.main.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getPosts() {
        return  this.postRepository.findAll();
    }

    public Post savePost(Post post) {
      return this.postRepository.save(post);
    }

    public Post getPost(int id) {
        return this.postRepository.findById(id);
    }

    public Post getPost(String st) {
            return this.postRepository.findByTitleLike(st);
    }

    public String deletePost(int id) {
        this.postRepository.delete(this.getPost(id));
        return "Post deleted";
    }
}
