package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.User;

import java.util.List;

public interface UserService {
    User register(User User);
    User updateUser(User user,Integer id);

    User getUserById(Integer id);

    void deleteUser(Integer id);
    List<User> getAllUsers();
}


