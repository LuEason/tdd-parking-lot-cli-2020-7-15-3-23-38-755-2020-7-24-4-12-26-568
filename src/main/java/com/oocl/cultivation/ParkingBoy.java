package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public CarTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                if (parkingLot.havePosition()) {
                    return parkingLot.parking(car);
                }
            } catch (Exception e) {
                continue;
            }

        }
        return parkingLots.get(0).parking(car);
    }

    public Car fetch(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                Car car = parkingLot.fetchTheCar(carTicket);
                if (car != null) {
                    return car;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return parkingLots.get(0).fetchTheCar(carTicket);
    }
}
