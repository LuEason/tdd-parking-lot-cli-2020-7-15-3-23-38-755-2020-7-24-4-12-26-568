package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public CarTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.havePosition().containsKey(Boolean.TRUE)) {
                return parkingLot.parking(car);
            }
        }
        return parkingLots.get(0).parking(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLots.get(0).fetchTheCar(carTicket);
    }
}
