package com.oocl.cultivation;

import java.util.Map;

public interface Validator {
    boolean validate(CarTicket carTicket, Map<CarTicket, Car> parkingRoom);
}
