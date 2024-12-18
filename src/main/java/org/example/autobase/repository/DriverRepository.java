package org.example.autobase.repository;

import org.example.autobase.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT a FROM Driver a where a.name = :name")
    public List<Driver> findByUsername(@Param("name") String username);
}


