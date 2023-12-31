package com.example.demo.repositories;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List <Car> findAll();
    Car findAllById(Long id);
    void deleteById(Long id);
}
