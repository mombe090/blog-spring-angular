package com.mombesoft.springbootvuejs.main.seeder;

import com.github.javafaker.Faker;
import com.mombesoft.springbootvuejs.main.entities.Comment;
import com.mombesoft.springbootvuejs.main.entities.Post;
import com.mombesoft.springbootvuejs.main.entities.User;
import com.mombesoft.springbootvuejs.main.services.CommentService;
import com.mombesoft.springbootvuejs.main.services.PostService;
import com.mombesoft.springbootvuejs.main.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DatabaseTableSeeder implements CommandLineRunner {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    public static Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        UserTableSeeder();
        PostTableSeeder();
        CommentTableSeeder();
    }

    private void UserTableSeeder() {
        if (this.userService.getUsers().isEmpty()) {

            for (int i=0; i < 10; i++) {
                User user = new User
                        (
                                faker.name().name(),
                                faker.internet().safeEmailAddress(),
                                faker.name().username(),
                                BCrypt.hashpw("123456", BCrypt.gensalt())
                        );
                this.userService.saveUser(user);
            }
        }


        String encryptedPassword = this.userService.getUser(1).getPassword();
        System.out.println(encryptedPassword);
    }

    private void PostTableSeeder() {
        if (this.postService.getPosts().isEmpty()) {

            for (int i=0; i < 10; i++) {
                Post post = new Post
                        (
                                faker.app().name() + i, faker.address().fullAddress(), this.userService.getUser(i + 1), faker.internet().image()
                        );
               this.postService.savePost(post);
            }
        }
    }
    private void CommentTableSeeder() {
        if (this.commentService.commentRepository.findAll().isEmpty()) {
            Random random = new Random();
            for (int i=0; i < 1000; i++) {
                Comment comment = new Comment(
                                faker.app().name(),
                                this.userService.getUser(random.nextInt(10)+1),
                                this.postService.getPost(random.nextInt(10)+1)
                        );
               this.commentService.saveComment(comment);
            }
        }
    }
}
