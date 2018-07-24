package com.mombesoft.springbootvuejs.main.controllers;

import com.mombesoft.springbootvuejs.main.entities.Post;
import com.mombesoft.springbootvuejs.main.services.PostService;
import com.mombesoft.springbootvuejs.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity index() {
        List<Post> posts = this.postService.getPosts();
        if (!posts.isEmpty()) {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(Arrays.asList(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity store(@RequestBody Post post) {
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity show(@PathVariable int id) {
        Post post = this.postService.getPost(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody Post post) {
        this.postService.savePost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity destroy(@PathVariable int id) {

        String msg = this.postService.deletePost(id);

        return new  ResponseEntity<>( null, HttpStatus.ACCEPTED);
    }

}
