package com.mombesoft.springbootvuejs.main.services;

import com.mombesoft.springbootvuejs.main.entities.User;
import com.mombesoft.springbootvuejs.main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return  this.userRepository.findAll();
    }

    public User saveUser(User user) {
      return this.userRepository.save(user);
    }

    public User getUser(int id) {
        return this.userRepository.findById(id);
    }

    public User getUser(String st) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);

        if (matcher.matches()) {
            return null; //this.userRepository.findByEmail(st);
        } else {
            return this.userRepository.findByUsername(st);
        }
    }

    public String deleteUser(int id) {
        this.userRepository.delete(this.getUser(id));
        return "User deleted";
    }
}
