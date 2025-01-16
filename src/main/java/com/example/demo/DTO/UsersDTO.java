package com.example.demo.DTO;

public class UsersDTO {
    private int id;
    private String userName;
    private String userAddress;
    private int userAge;
    private boolean userGender;
    private int userBloodSugerLevel;
    private String password;

    public UsersDTO() {}
    public UsersDTO(int id, String userName, String userAddress, int userAge, boolean userGender, int userBloodSugerLevel) {
        this.id = id;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userBloodSugerLevel = userBloodSugerLevel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
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
