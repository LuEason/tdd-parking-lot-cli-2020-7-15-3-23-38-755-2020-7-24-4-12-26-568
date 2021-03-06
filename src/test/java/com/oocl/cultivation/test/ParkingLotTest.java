package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot;

    @BeforeEach
    void setup() {
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

    @Test
    void should_return_map_contain_TRUE_when_havePosition_and_parkingRoom_is_empty() {
        //given

        //when
        boolean havePosition = parkingLot.havePosition();

        //then
        assertTrue(havePosition);
    }

    @Test
    void should_return_map_contain_FALSE_and_throw_exception_when_havePosition_and_parkingRoom_is_full() {
        //given
        parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car());

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parkingLot.havePosition());

        //then
        assertEquals("Not enough position.", exception.getMessage());
    }


    @Test
    void should_return_empty_position_count_when_countEmptyPosition() {
        //given
        parkingLot = new ParkingLot();
        parkingLot.parking(new Car());

        //when
        int emptyPositionCount = parkingLot.countEmptyPosition();

        //then
        assertEquals(9, emptyPositionCount);
    }


    @Test
    void should_return_capacity_when_getCapacity() {
        //given
        parkingLot = new ParkingLot();
        parkingLot.parking(new Car());

        //when
        int capacity = parkingLot.getCapacity();

        //then
        assertEquals(10, capacity);
    }
}
