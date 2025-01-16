package com.example.demo.DTO;

import java.time.LocalDate;

public class HistoryDTO {
    private int id;
    private int userId;
    private int bloodSugerHistory;
    private LocalDate checkDate;
    private String session;
    private int diseaseLevel;

    public HistoryDTO() {}
    public HistoryDTO(int id, int userId, int bloodSugerHistory, LocalDate checkDate, String session, int diseaseLevel) {
        this.id = id;
        this.userId = userId;
        this.bloodSugerHistory = bloodSugerHistory;
        this.checkDate = checkDate;
        this.session = session;
        this.diseaseLevel = diseaseLevel;
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

    public int getBloodSugerHistory() {
        return bloodSugerHistory;
    }

    public void setBloodSugerHistory(int bloodSugerHistory) {
        this.bloodSugerHistory = bloodSugerHistory;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getDiseaseLevel() {
        return diseaseLevel;
    }

    public void setDiseaseLevel(int diseaseLevel) {
        this.diseaseLevel = diseaseLevel;
    }
}
