package com.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Plans {
    @Id @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;
    @Column(nullable = false)
    private String session;
    @Column(nullable = false)
    private LocalDate planDate;

    public int getId() {
        return id;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
