package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String userAddress;
    @Column(nullable = false)
    private int userAge;
    @Column(nullable = false)
    private boolean userGender;
    @Column(nullable = false)
    private int userBloodSugerLevel;
    @Column(nullable = false)
    private String password;


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isUserGender() {
        return userGender;
    }

    public void setUserGender(boolean userGender) {
        this.userGender = userGender;
    }

    public int getUserBloodSugerLevel() {
        return userBloodSugerLevel;
    }

    public void setUserBloodSugerLevel(int userBloodSugerLevel) {
        this.userBloodSugerLevel = userBloodSugerLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
