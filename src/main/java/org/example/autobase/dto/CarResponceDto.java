package org.example.autobase.dto;

import org.example.autobase.entity.Car;

public class CarResponceDto {
    private String model;
    private boolean isOperational;

    public void CarResponceDto(Car car) {
        this.model = car.getModel();
        this.isOperational = car.getIsOperational();
    }
}
