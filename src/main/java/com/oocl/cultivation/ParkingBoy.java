package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return new CarTicket();
    }

    public Car fetch(CarTicket carTicket) {
        return new Car();
    }
}
