package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class CarTicketValidator implements Validator {

    @Override
    public Map<Boolean, String> validate(CarTicket carTicket, Map<CarTicket, Car> parkingRoom) {
        Map<Boolean, String> resultMap = new HashMap<>();
        if (carTicket == null) {
            //todo
            resultMap.put(Boolean.FALSE, "Please provide your parking ticket.");
        } else if (!parkingRoom.containsKey(carTicket)) {
            resultMap.put(Boolean.FALSE, "Unrecognized parking ticket.");
        } else {
            resultMap.put(Boolean.TRUE, "");
        }
        return resultMap;
    }
}
