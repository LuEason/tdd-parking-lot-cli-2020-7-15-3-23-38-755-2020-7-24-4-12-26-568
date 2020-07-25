package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {
    private ParkingBoy parkingBoy;

    @BeforeEach
    public void setup() {
        parkingBoy = new ParkingBoy();
    }

    @Test
    void should_return_CarTicket_when_park_given_car() {
        //given
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }
    @Test
    void should_fetch_car_when_fetch_given_car_ticket() {
        //given
        CarTicket carTicket = new CarTicket();

        //when
        Car car = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(car);
    }
}
