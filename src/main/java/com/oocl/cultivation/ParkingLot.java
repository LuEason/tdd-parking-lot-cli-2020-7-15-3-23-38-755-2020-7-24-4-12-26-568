package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private int capacity;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket parking(Car car) {
        if (parkingRoom.size() < capacity) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public Car fetchTheCar(CarTicket carTicket) {
        return  parkingRoom.remove(carTicket);
    }
}
