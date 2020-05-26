package com.eis.clientapi.services;

import com.eis.clientapi.entities.User;
import com.eis.clientapi.event.EventPublisher;
import com.eis.clientapi.exceptions.UserNotFoundException;
import com.eis.clientapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventPublisher<User> eventPublisher;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User addOne(User data) {
        User object = userRepository.save(data);
        eventPublisher.publish(object, "ADD_USER");
        return object;
    }

    public User getOne(int id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User fullUpdateOne(int id, User data){
        User object = userRepository.findById(id).map(user -> {
            user.setEmail(data.getEmail());
            user.setFirstname(data.getFirstname());
            user.setLastname(data.getLastname());
            user.setRole(data.getRole());
            user.setUsername(data.getUsername());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
        eventPublisher.publish(object, "UPDATE_USER");
        return object;
    }

    public User partialUpdateOne(int id, User data){
        User object = userRepository.findById(id).map(user -> {
            if(data.getEmail() != null) user.setEmail(data.getEmail());
            if(data.getFirstname() != null) user.setFirstname(data.getFirstname());
            if(data.getLastname() != null) user.setLastname(data.getLastname());
            if(data.getRole() != null) user.setRole(data.getRole());
            if(data.getUsername() != null) user.setUsername(data.getUsername());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
        eventPublisher.publish(object, "UPDATE_USER");
        return object;
    }

    public User deleteOne(int id){
        User object = userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return user;
        }).orElseThrow(() -> new UserNotFoundException(id));
        eventPublisher.publish(object, "DELETE_USER");
        return object;
    }
}
