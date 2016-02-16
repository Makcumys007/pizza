package com.epam.pizza.factory;

import com.epam.pizza.model.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by advirtys on 16.02.16.
 */
public class FactoryAddress {
    private static List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();

        Address adr = new Address();
        adr.setAddressee("Max");
        adr.setStreet("Republic");
        adr.setHouseNumber("18/2");
        adr.setFlatNumber(8);
        addresses.add(adr);

        adr = new Address();
        adr.setAddressee("Vasa");
        adr.setStreet("Sabitova");
        adr.setHouseNumber("20");
        adr.setFlatNumber(20);
        addresses.add(adr);

        adr = new Address();
        adr.setAddressee("Petya");
        adr.setStreet("Muhametjanova");
        adr.setHouseNumber("6");
        adr.setFlatNumber(16);
        addresses.add(adr);

        return addresses;
    }

    public static Address getAddress(int index) {
        return getAddresses().get(index);
    }
}
