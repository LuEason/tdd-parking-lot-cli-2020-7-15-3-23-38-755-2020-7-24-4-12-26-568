package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        int largestAvailablePositionRateLotIndex = 0;
        double largestAvailablePositionRate = (double) parkingLots.get(0).countEmptyPosition() / parkingLots.get(0).getCapacity();
        for (ParkingLot parkingLot : parkingLots) {
            double availablePositionRate = (double) parkingLot.countEmptyPosition() / parkingLot.getCapacity();
            if (availablePositionRate > largestAvailablePositionRate) {
                largestAvailablePositionRateLotIndex = parkingLots.indexOf(parkingLot);
                largestAvailablePositionRate = availablePositionRate;
            }
        }
        return parkingLots.get(largestAvailablePositionRateLotIndex).parking(car);
    }
}
