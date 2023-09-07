package com.example.demo.service;

import com.example.demo.dto.CarForm;
import com.example.demo.model.Car;
import com.example.demo.model.User;

import java.util.List;

public interface CarService {
    List <Car> getAllCars();
    void addUserToCar(Long userId, Long carId);
    Car getCar(Long carId);
    List<User> getNotInCarUsers(Long carId);
    List<User>getInCarUsers(Long carId);
    void deleteCar(Long id);
    void addCar(CarForm car);
    void updateCar(Long carId, CarForm car);

}
