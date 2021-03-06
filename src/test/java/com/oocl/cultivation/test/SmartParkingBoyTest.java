package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartParkingBoyTest {

    @Test
    void should_park_the_car_in_the_second_parking_lot_and_return_car_ticket_when_the_second_park_have_larger_position_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        parkingLots.add(firstParkingLot);
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLots.add(secondParkingLot);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
        assertTrue(firstParkingLot.havePosition());
    }
}
