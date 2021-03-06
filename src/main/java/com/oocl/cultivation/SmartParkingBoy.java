package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        int mostEmptyPositionsLotIndex = 0;
        int mostEmptyPositions = parkingLots.get(0).countEmptyPosition();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.countEmptyPosition() > mostEmptyPositions) {
                mostEmptyPositionsLotIndex = parkingLots.indexOf(parkingLot);
                mostEmptyPositions = parkingLot.countEmptyPosition();
            }
        }
        return parkingLots.get(mostEmptyPositionsLotIndex).parking(car);
    }
}
