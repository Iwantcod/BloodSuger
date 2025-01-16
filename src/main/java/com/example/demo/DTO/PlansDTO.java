package com.example.demo.DTO;

import java.time.LocalDate;

public class PlansDTO {
    private int id;
    private int userId;
    private String session;
    private LocalDate planDate;

    public PlansDTO() {}
    public PlansDTO(int id, int userId, String session, LocalDate planDate) {
        this.id = id;
        this.userId = userId;
        this.session = session;
        this.planDate = planDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public LocalDate getPlanDate() {
        return planDate;
    }

    public void setPlanDate(LocalDate planDate) {
        this.planDate = planDate;
    }
}
