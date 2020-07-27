package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.CarTicketValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarTicketValidatorTest {
    private CarTicketValidator carTicketValidator;

    @BeforeEach
    void setup() {
        carTicketValidator = new CarTicketValidator();
    }

    @Test
    void should_throw_exception_when_validate_given_no_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> carTicketValidator.validate(null, parkingRoom));

        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_validate_given_wrong_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> carTicketValidator.validate(wrongCarTicket, parkingRoom));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return__TRUE_when_validate_given_right_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);

        //when
        boolean validate = carTicketValidator.validate(carTicket, parkingRoom);

        //then
        assertTrue(validate);
    }
}
