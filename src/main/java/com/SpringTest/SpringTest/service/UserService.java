package com.SpringTest.SpringTest.service;

import org.springframework.stereotype.Service;

import com.SpringTest.SpringTest.entity.User;
import com.SpringTest.SpringTest.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public User updateUserById(Integer id, User userUpdated){
        User user = userRepository.findById(id).get();
        //Setters
        return user;
    }

    public boolean deleteUserById(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
