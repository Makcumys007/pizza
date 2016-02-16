package com.epam.pizza.model;

/**
 * Created by advirtys on 16.02.16.
 */
public class Address {
    private String name;
    private String lastName;
    private String street;
    private String houseNumber;
    private int flatNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address street=" + street +
                ", houseNumber=" + houseNumber +
                ", flatNumber=" + flatNumber +
                ", name=" + name +
                ", lastname=" + lastName;
    }
}
