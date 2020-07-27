package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    private ParkingBoy parkingBoy;

    @BeforeEach
    void setup() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        parkingBoy = new ParkingBoy(parkingLots);
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
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(wrongCarTicket));
        });

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
    }

    @Test
    void should_fetch_null_when_fetch_given_null() {
        //given
        Car car = new Car();
        parkingBoy.park(car);
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(null));
        });

        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
    }

    @Test
    void should_fetch_null_when_fetch_given_used_car_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetch(carTicket);
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(carTicket));
        });

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
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
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingBoy = new ParkingBoy(parkingLots);

        //when
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_null_when_capacity_is_1_and_park_is_full_given_car() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingBoy = new ParkingBoy(parkingLots);
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
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(wrongCarTicket));
        });

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
    }

    @Test
    void should_fetch_null_and_print_Unrecognized_parking_ticket_when_fetch_given_used_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetch(carTicket);
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(carTicket));
        });

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
    }

    @Test
    void should_fetch_null_and_print_Please_provide_your_parking_ticket_when_fetch_given_null() {
        //given
        Car car = new Car();
        parkingBoy.park(car);
        AtomicReference<Car> fetchedCar = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fetchedCar.set(parkingBoy.fetch(null));
        });

        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
        assertNull(fetchedCar.get());
    }

    @Test
    void should_return_null_and_print_Not_enough_position_when_park_is_full_given_car() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);
        Car anOtherCar = new Car();
        AtomicReference<CarTicket> carTicket = new AtomicReference<>();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            carTicket.set(parkingBoy.park(anOtherCar));
        });

        //then
        assertEquals("Not enough position.", exception.getMessage());
        assertNull(carTicket.get());
    }

    @Test
    void should_park_the_car_in_the_second_parking_lot_and_return_car_ticket_when_the_first_park_is_full_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot());
        parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());
        Car anOtherCar = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(anOtherCar);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_in_the_correspond_parking_lot_when_the_first_park_is_full_given_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot());
        parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        Car anOtherCar = new Car();
        CarTicket carTicket = parkingBoy.park(anOtherCar);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertEquals(anOtherCar, fetchedCar);
    }
}
