package com.oocl.cultivation;

import java.util.Map;

public class CarTicketValidator implements Validator {

    @Override
    public boolean validate(CarTicket carTicket, Map<CarTicket, Car> parkingRoom) {
        return parkingRoom.containsKey(carTicket);
    }
}
