package org.example.autobase.dto;
import org.example.autobase.entity.Driver;

public class DriverResponceDto {
    private String name;
    private boolean isAvailable;
    private boolean isSuspended;

    public void DriverResponceDto(Driver driver) {
        this.name = driver.getName();
        this.isAvailable = driver.getIsAvailable();
        this.isSuspended = driver.getIsSuspended();
    }
}
