package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Details {
    @Id @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "foodId", nullable = false)
    private Food food;
    @ManyToOne
    @JoinColumn(name = "planId", nullable = false)
    private Plans plans;

    public int getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Plans getPlans() {
        return plans;
    }

    public void setPlans(Plans plans) {
        this.plans = plans;
    }
}
