package com.epam.pizza.model;

public class Address {
    private String addressee;
    private String street;
    private String houseNumber;
    private int flatNumber;

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
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
                ", addressee=" + addressee;
    }
}
