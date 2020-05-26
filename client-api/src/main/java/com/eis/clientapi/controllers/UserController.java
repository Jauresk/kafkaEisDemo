package com.eis.clientapi.controllers;

import com.eis.clientapi.entities.User;
import com.eis.clientapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public User addOne(@RequestBody User data){
        return userService.addOne(data);
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id){
        return userService.getOne(id);
    }

    @PutMapping("/{id}")
    public User fullUpdateOne(@PathVariable int id, @RequestBody User data){
        return userService.fullUpdateOne(id, data);
    }

    @PatchMapping("/{id}")
    public User partialUpdateOne(@PathVariable int id, @RequestBody User data){
        return userService.partialUpdateOne(id, data);
    }

    @DeleteMapping("/{id}")
    public User disableUser(@PathVariable int id){
        return userService.deleteOne(id);
    }
}
