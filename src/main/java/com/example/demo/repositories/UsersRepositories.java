package com.example.demo.repositories;

import com.example.demo.model.Car;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepositories extends JpaRepository <User,Long>{

    List<User> findAll();
    List <User> findAllByCarsContains(Car car);
    List <User> findAllByCarsNotContains(Car car);
    User findAllById(Long id);

    void deleteUserById (Long id);
}
