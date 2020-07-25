package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot();
    }

    @Test
    void should_return_CarTicket_when_parking_given_car() {
        //given
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.parking(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetchTheCar_given_car_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingLot.parking(car);

        //when
        Car fetchedCar = parkingLot.fetchTheCar(carTicket);

        //then
        assertNotNull(fetchedCar);
    }
}
