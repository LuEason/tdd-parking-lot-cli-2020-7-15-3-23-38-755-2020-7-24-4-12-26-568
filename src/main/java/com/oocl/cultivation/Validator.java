package com.oocl.cultivation;

import java.util.Map;

public interface Validator {
    Map<Boolean, String> validate(CarTicket carTicket, Map<CarTicket, Car> parkingRoom);
}
