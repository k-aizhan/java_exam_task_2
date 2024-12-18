package org.example.autobase.repository;

import org.example.autobase.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT a FROM Car a where a.model = :model")
    public List<Car> findByCarModel(@Param("model") String name);
}
