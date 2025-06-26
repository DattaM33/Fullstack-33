package com.D33.CURDOpration.controller;

import com.D33.CURDOpration.exception.UserNotFoundException;
import com.D33.CURDOpration.model.User;
import com.D33.CURDOpration.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
   private Userrepo userrepo;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser)
    {
       return userrepo.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAll()
    {
        return userrepo.findAll();
    }

    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id)
    {
        return userrepo.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }


    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userrepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userrepo.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/user/{id}")
     String deleteUser(@PathVariable Long id)
    {
        if(!userrepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userrepo.deleteById(id);
        return "User with id "+id+"has been deleted success";
    }
}