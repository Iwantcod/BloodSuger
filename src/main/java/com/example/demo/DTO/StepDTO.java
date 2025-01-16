package com.example.demo.DTO;

import com.example.demo.Entity.Food;

public class StepDTO {
    private int id;
    private int foodId;
    private String step;
    private int pageNum;

    public StepDTO() {}
    public StepDTO(int id, int foodId, String step, int pageNum) {
        this.id = id;
        this.foodId = foodId;
        this.step = step;
        this.pageNum = pageNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
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
