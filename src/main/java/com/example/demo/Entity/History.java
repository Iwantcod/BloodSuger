package com.example.demo.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class History {
    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @Column(nullable = false)
    private int bloodSugerHistory;
    @Column(nullable = false)
    private LocalDate checkDate;
    @Column(nullable = false)
    private String session;
    private int diseaseLevel;

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
