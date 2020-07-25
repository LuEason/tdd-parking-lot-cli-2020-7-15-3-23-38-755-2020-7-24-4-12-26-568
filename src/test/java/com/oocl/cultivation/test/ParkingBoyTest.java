package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    private ParkingBoy parkingBoy;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String systemOut() {
        return outContent.toString();
    }

    @BeforeEach
    public void setup() {
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        System.setOut(new PrintStream(outContent));
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
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
    }

    @Test
    void should_fetch_car_when_fetch_given_right_car_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_fetch_null_when_fetch_given_wrong_car_ticket() {
        //given
        Car car = new Car();
        parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Car fetchedCar = parkingBoy.fetch(wrongCarTicket);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_fetch_null_when_fetch_given_null() {
        //given
        Car car = new Car();
        parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(null);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_fetch_null_when_fetch_given_used_car_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetch(carTicket);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_car_ticket_when_park_is_empty_given_car() {
        //given
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_ticket_when_capacity_is_1_and_park_is_empty_given_car() {
        //given
        Car car = new Car();
        parkingBoy = new ParkingBoy(new ParkingLot(1));

        //when
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_null_when_capacity_is_1_and_park_is_full_given_car() {
        //given
        Car car = new Car();
        parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(car);
        Car anOtherCar = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(anOtherCar);

        //then
        assertNull(carTicket);
    }

    @Test
    void should_fetch_null_and_print_Unrecognized_parking_ticket_when_fetch_given_wrong_ticket() {
        //given
        Car car = new Car();
        parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Car fetchedCar = parkingBoy.fetch(wrongCarTicket);

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", systemOut());
    }

    @Test
    void should_fetch_null_and_print_Unrecognized_parking_ticket_when_fetch_given_used_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetch(carTicket);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", systemOut());
    }

    @Test
    void should_fetch_null_and_print_Please_provide_your_parking_ticket_when_fetch_given_null() {
        //given
        Car car = new Car();
        parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(null);

        //then
        assertNull(fetchedCar);
        assertEquals("Please provide your parking ticket.", systemOut());
    }
}
