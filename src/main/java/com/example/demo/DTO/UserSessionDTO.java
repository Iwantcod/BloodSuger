package com.example.demo.DTO;

public class UserSessionDTO {
    private int userId;
    private String userName;
    private boolean isLoggedIn;

    public UserSessionDTO() {}
    public UserSessionDTO(int userId, String userName, boolean isLoggedIn) {
        this.userId = userId;
        this.userName = userName;
        this.isLoggedIn = isLoggedIn;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
