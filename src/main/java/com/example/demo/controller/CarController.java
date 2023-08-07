package com.example.demo.controller;

import com.example.demo.dto.CarForm;
import com.example.demo.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping("/car/{id}/users")
    public String addUserToCar(@PathVariable("id") Long carId,
                                     @RequestParam("user-id") Long userId) {
       carService.addUserToCar(userId,carId);
        return "redirect:/cars/" + carId;
    }

    @GetMapping("/cars/{id}")
    public String getCarPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("notInCarUsers", carService.getNotInCarUsers(id));
        model.addAttribute("inCarUsers", carService.getInCarUsers(id));
        return "car";
    }
    @GetMapping("/cars")
    public String getCarsPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }
    @PostMapping("/cars")
    public String addCar(CarForm car) {
        carService.addCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/cars/{id}/delete")
    public String updateCar(@PathVariable("id") Long carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }
    @PostMapping("/car/{id}/update")
    public String updateCourse(@PathVariable("id") Long carId, CarForm car) {
        carService.updateCar(carId, car);
        return "redirect:/cars/" + carId;
    }


}
