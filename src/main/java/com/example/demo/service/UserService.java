package com.example.demo.service;

import com.example.demo.dto.UserForm;
import com.example.demo.model.User;


import java.util.List;

public interface UserService {

    List<User> getAllUsers();


    void updateUser(Long userId, UserForm user);

    User getUserById(Long id);

    void addUser(UserForm user);

    void deleteUser(Long id);
}
