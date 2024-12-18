package org.example.autobase.repository;

import org.example.autobase.entity.Driver;
import org.example.autobase.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT a FROM Trip a where a.destination = :destination")
    public List<Driver> findByTripDestination(@Param("destination") String username);
}
