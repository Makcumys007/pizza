package com.epam.pizza.model;

import org.junit.Test;
import static junit.framework.Assert.*;

public class AddressTest {
    @Test
    public void testAddress() {
        Address address = new Address();
        address.setName("Max");
        address.setLastName("Abylkassov");
        address.setStreet("Republic");
        address.setHouseNumber("18/2");
        address.setFlatNumber(8);

        assertEquals("Address street=Republic, houseNumber=18/2," +
                " flatNumber=8, name=Max, lastname=Abylkassov", address.toString());
    }
}
