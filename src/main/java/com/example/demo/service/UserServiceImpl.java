package com.example.demo.service;
import com.example.demo.dto.UserForm;
import com.example.demo.model.User;
import com.example.demo.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {

@Autowired
    private  final  UsersRepositories usersRepository;
    public UserServiceImpl(UsersRepositories usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    public void updateUser(Long userId, UserForm user) {
        User userForUpdate = usersRepository.findById(userId).orElseThrow();
        userForUpdate.setFirstName(user.getFirstName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setEmail(user.getEmail());

        usersRepository.save(userForUpdate);
    }

    @Override
    public User getUserById(Long id) {
        return  usersRepository.findAllById(id);
    }

    @Override
    public void addUser(UserForm user) {
        User newUser = User.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        usersRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteUserById(id);

    }
}
