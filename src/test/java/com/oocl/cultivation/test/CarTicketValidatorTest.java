package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.CarTicketValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTicketValidatorTest {
    private CarTicketValidator carTicketValidator;

    @BeforeEach
    public void setup() {
        carTicketValidator = new CarTicketValidator();
    }

    @Test
    void should_return_Map_With_Unrecognized_parking_ticket_when_validate_given_no_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);

        //when
        Map<Boolean, String> result = carTicketValidator.validate(null, parkingRoom);

        //then
        assertEquals("Please provide your parking ticket.", result.get(Boolean.FALSE));
    }

    @Test
    void should_return_Map_With_Unrecognized_parking_ticket_when_validate_given_wrong_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Map<Boolean, String> result = carTicketValidator.validate(wrongCarTicket, parkingRoom);

        //then
        assertEquals("Unrecognized parking ticket.", result.get(Boolean.FALSE));
    }

    @Test
    void should_return_Map_With_TRUE_when_validate_given_right_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        Map<CarTicket, Car> parkingRoom = new HashMap<>();
        parkingRoom.put(carTicket, car);

        //when
        Map<Boolean, String> result = carTicketValidator.validate(carTicket, parkingRoom);

        //then
        assertEquals("", result.get(Boolean.TRUE));
    }
}
