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
        if (havePosition().containsKey(Boolean.TRUE)) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            System.out.print(havePosition().get(Boolean.FALSE));
            return null;
        }
    }

    public Map<Boolean, String> havePosition() {
        Map<Boolean, String> resultMap = new HashMap<>();
        if (parkingRoom.size() < capacity) {
            resultMap.put(Boolean.TRUE, "");
        } else {
            resultMap.put(Boolean.FALSE, "Not enough position.");
        }
        return resultMap;
    }

    public Car fetchTheCar(CarTicket carTicket) {
        if (validator.validate(carTicket, parkingRoom).containsKey(Boolean.FALSE)) {
            System.out.print(validator.validate(carTicket, parkingRoom).get(Boolean.FALSE));
        }
        return  parkingRoom.remove(carTicket);
    }

    public int countEmptyPosition() {
        return capacity - parkingRoom.size();
    }
}
