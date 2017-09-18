
package com.target.androidaula6.json;


public class User {

    private String cell;
    private String dob;
    private String email;
    private String gender;
    private Id id;
    private Location location;
    private Login login;
    private Name name;
    private String nat;
    private String phone;
    private Picture picture;
    private String registered;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param picture
     * @param id
     * @param phone
     * @param location
     * @param email
     * @param registered
     * @param name
     * @param dob
     * @param cell
     * @param gender
     * @param nat
     * @param login
     */
    public User(String cell, String dob, String email, String gender, Id id, Location location, Login login, Name name, String nat, String phone, Picture picture, String registered) {
        super();
        this.cell = cell;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.location = location;
        this.login = login;
        this.name = name;
        this.nat = nat;
        this.phone = phone;
        this.picture = picture;
        this.registered = registered;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

}
