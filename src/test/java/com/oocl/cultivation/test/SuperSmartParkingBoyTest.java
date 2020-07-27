package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SuperSmartParkingBoyTest {

    @Test
    void should_park_the_car_in_the_second_parking_lot_and_return_car_ticket_when_the_first_park_has_a_larger_available_position_rate_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.parking(new Car());
        firstParkingLot.parking(new Car());
        firstParkingLot.parking(new Car());
        secondParkingLot.parking(new Car());
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
        assertEquals(2, firstParkingLot.countEmptyPosition());
        assertEquals(0, secondParkingLot.countEmptyPosition());
    }

    @Test
    void should_park_the_car_in_the_second_parking_lot_and_return_car_ticket_when_the_first_park_has_a_larger_available_position_rate_given_car2() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(9);
        firstParkingLot.parking(new Car());
        firstParkingLot.parking(new Car());
        for (int i = 0; i < 7; i++) {
            secondParkingLot.parking(new Car());
        }
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
        assertEquals(0, firstParkingLot.countEmptyPosition());
        assertEquals(2, secondParkingLot.countEmptyPosition());
    }
}
