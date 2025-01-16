package com.example.demo.DTO;

public class DetailsDTO {
    private int id;
    private int foodId;
    private int planId;

    public DetailsDTO() {}
    public DetailsDTO(int id, int foodId, int planId) {
        this.id = id;
        this.foodId = foodId;
        this.planId = planId;
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

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }
}
