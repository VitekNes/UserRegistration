package com.GenessisResources.UserRegistration.service;

import com.GenessisResources.UserRegistration.model.User;
import com.GenessisResources.UserRegistration.model.UserSimple;
import com.GenessisResources.UserRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<UserSimple> getAllUsersSimple(){
        List<User> users = getAllUsers();
        List<UserSimple> simpleUsers = new ArrayList<>();
        for(User user : users){
            simpleUsers.add(new UserSimple(user.getId(), user.getName(), user.getSurname()));
        }
        return simpleUsers;
    }

    public Optional<User> getUser(Integer id){
        return userRepository.findById(id);
    }

    public Optional<UserSimple> getUserSimple(Integer id){
        return getUser(id)
                .map(user -> new UserSimple(
                        user.getId(),
                        user.getName(),
                        user.getSurname()
                ));
    }
}
