package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private final Validator validator = new CarTicketValidator();
    private final int capacity;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket parking(Car car) {
        if (havePosition()) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        }
        return null;
    }

    public boolean havePosition() {
        if (parkingRoom.size() < capacity) {
            return true;
        } else {
            throw new RuntimeException("Not enough position.");
        }
    }

    public Car fetchTheCar(CarTicket carTicket) {
        if (validator.validate(carTicket, parkingRoom)) {
            return parkingRoom.remove(carTicket);
        }
        return null;
    }

    public int countEmptyPosition() {
        return capacity - parkingRoom.size();
    }

    public int getCapacity() {
        return capacity;
    }
}
