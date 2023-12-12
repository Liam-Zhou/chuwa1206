package org.example;

public class AddressInfo {
    private String country;
    private String state;
    private String city;
    private String street;
    private String zipcode;

    public AddressInfo(String country, String state, String city, String street, String zipcode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
