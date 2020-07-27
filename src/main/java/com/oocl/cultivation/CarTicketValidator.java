package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class CarTicketValidator implements Validator {

    @Override
    public boolean validate(CarTicket carTicket, Map<CarTicket, Car> parkingRoom) {
        if (carTicket == null) {
            throw new RuntimeException("Please provide your parking ticket.");
        } else if (!parkingRoom.containsKey(carTicket)) {
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return true;
    }
}
