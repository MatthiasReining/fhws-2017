package com.fhws.javaee.presentation;

import javax.validation.constraints.Size;

public class AppUser {

    private String email;
    private String password;

    @Size(min = 2)
    private String firstName;
    private String lastName;

    public AppUser() {
    }

    public AppUser(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AppUser{" + "email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
