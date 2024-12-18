package org.example.autobase.controller;

import org.example.autobase.entity.*;
import org.example.autobase.services.DispatcherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DispatcherController {

    private final DispatcherService dispatcherService;

    public DispatcherController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        return dispatcherService.createDriver(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return (List<Driver>) dispatcherService.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    public Optional<Driver> getDriverById(@PathVariable Long id) {
        return dispatcherService.getDriverById(id);
    }

    @PutMapping("/drivers/{id}")
    public Driver updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        return dispatcherService.updateDriver(id, driver);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable Long id) {
        dispatcherService.deleteDriver(id);
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return dispatcherService.createCar(car);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return (List<Car>) dispatcherService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return dispatcherService.getCarById(id);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return dispatcherService.updateCar(id, car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        dispatcherService.deleteCar(id);
    }

    @PostMapping("/trips")
    public Trip createTrip(@RequestBody Trip trip) {
        return dispatcherService.createTrip(trip);
    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return (List<Trip>) dispatcherService.getAllTrips();
    }

    @GetMapping("/trips/{id}")
    public Optional<Trip> getTripById(@PathVariable Long id) {
        return dispatcherService.getTripById(id);
    }

    @PutMapping("/trips/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return dispatcherService.updateTrip(id, trip);
    }
    @DeleteMapping("/trips/{id}")
    public void deleteTrip(@PathVariable Long id) {
        dispatcherService.deleteTrip(id);
    }
}

