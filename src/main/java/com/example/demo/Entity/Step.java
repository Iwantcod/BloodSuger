package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Step {
    @Id @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId", nullable = false)
    private Food food;

    @Column(nullable = false, length = 1000)
    private String step;
    @Column(nullable = false)
    private int pageNum;

    public int getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
