
package com.target.androidaula6.json;


public class Location {

    private String city;
    private Integer postcode;
    private String state;
    private String street;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param street
     * @param state
     * @param postcode
     * @param city
     */
    public Location(String city, Integer postcode, String state, String street) {
        super();
        this.city = city;
        this.postcode = postcode;
        this.state = state;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
