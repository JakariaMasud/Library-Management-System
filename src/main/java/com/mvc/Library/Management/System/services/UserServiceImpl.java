package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.User;
import com.mvc.Library.Management.System.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer id) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
