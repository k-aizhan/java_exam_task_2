package org.example.autobase.services;

import org.example.autobase.entity.Car;
import org.example.autobase.entity.Driver;
import org.example.autobase.entity.Trip;
import org.example.autobase.repository.CarRepository;
import org.example.autobase.repository.DriverRepository;
import org.example.autobase.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service

public class DispatcherService {

    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final TripRepository tripRepository;

    public DispatcherService(DriverRepository driverRepository, CarRepository carRepository, TripRepository tripRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.tripRepository = tripRepository;
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver updateDriver(Long id, Driver updatedDriver) {
        Driver driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setName(updatedDriver.getName());
        driver.setAvailable(updatedDriver.isAvailable());
        driver.setSuspended(updatedDriver.isSuspended());
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setModel(updatedCar.getModel());
        car.setOperational(updatedCar.isOperational());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }
    public Trip updateTrip(Long id, Trip updatedTrip) {
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setDestination(updatedTrip.getDestination());
        trip.setCompleted(updatedTrip.isCompleted());
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip assignTrip(Long driverId, Long carId, String destination) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));

        if (!driver.isAvailable() || !car.isOperational()) {
            throw new RuntimeException("Driver or car is unavailable");
        }

        Trip trip = new Trip();
        trip.setDriver(driver);
        trip.setCar(car);
        trip.setDestination(destination);
        trip.setCompleted(false);

        return tripRepository.save(trip);
    }
    public void suspendDriver(Long driverId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setSuspended(true);
        driverRepository.save(driver);
    }

    public void markTripCompleted(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setCompleted(true);
        tripRepository.save(trip);
    }

    public void reportCarRepair(Long carId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setOperational(false);
        carRepository.save(car);
    }
}

