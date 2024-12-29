package com.example.parkinglot.common;

import java.util.List;
import java.util.logging.Logger;


public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    String ownerName;

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }


    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }





}
