package com.example.demo.service;

import com.example.demo.dto.CarForm;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    public final CarRepository carRepository;
    public CarServiceImpl(CarRepository carRepository, UsersRepositories usersRepositories) {
        this.carRepository = carRepository;
        this.usersRepositories = usersRepositories;
    }
    @Autowired
    public final UsersRepositories usersRepositories;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void addUserToCar(Long userId, Long carId) {
        Car car =carRepository.findAllById(carId);
        User user =usersRepositories.findAllById(userId);
        user.getCars().add(car);
        usersRepositories.save(user);
    }

    @Override
    public Car getCar(Long carId) {
        return carRepository.findAllById(carId);
    }

    @Override
    public List<User> getNotInCarUsers(Long carId) {
        Car car =carRepository.findAllById(carId);
        return usersRepositories.findAllByCarsNotContains(car);
    }

    @Override
    public List<User> getInCarUsers(Long carId) {
        Car car =carRepository.findAllById(carId);
        return usersRepositories.findAllByCarsContains(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void addCar(CarForm car) {
        Car newCar = Car.builder()
                .model(car.getModel())
                .series(car.getSeries())
                .build();
        carRepository.save(newCar);
    }

    @Override
    public void updateCar(Long carId, CarForm car) {
        Car carForUpdate = carRepository.findAllById(carId);
        carForUpdate.setModel(car.getModel());
        carForUpdate.setSeries(car.getSeries());
        carRepository.save(carForUpdate);
    }
}
