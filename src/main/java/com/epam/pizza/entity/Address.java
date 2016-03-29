package com.epam.pizza.entity;

public class Address extends BaseEntity {
    private String addressee;
    private String street;
    private String houseNumber;
    private int flatNumber;

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        isNull(addressee);
        this.addressee = addressee;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        isNull(street);
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        isNull(houseNumber);
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        isNull(flatNumber);
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
