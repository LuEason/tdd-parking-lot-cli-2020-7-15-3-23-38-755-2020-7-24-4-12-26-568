package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.parking(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.fetchTheCar(carTicket);
    }
}
