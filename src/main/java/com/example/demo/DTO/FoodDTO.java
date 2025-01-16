package com.example.demo.DTO;

import org.springframework.web.multipart.MultipartFile;

public class FoodDTO {
    private int id;
    private String foodName;
    private String foodCategory;
    private String ingredients;
    private MultipartFile foodImage;
    private int sodium_mg;
    private int potassium_g;
    private int protein_g;
    private int phosphours_g;

    public FoodDTO() {}
    public FoodDTO(int id, String foodName, String foodCategory, String ingredients, MultipartFile foodImage, int sodium_mg, int potassium_g, int protein_g, int phosphours_g) {
        this.id = id;
        this.foodName = foodName;
        this.foodCategory = foodCategory;
        this.ingredients = ingredients;
        this.foodImage = foodImage;
        this.sodium_mg = sodium_mg;
        this.potassium_g = potassium_g;
        this.protein_g = protein_g;
        this.phosphours_g = phosphours_g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public MultipartFile getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(MultipartFile foodImage) {
        this.foodImage = foodImage;
    }

    public int getSodium_mg() {
        return sodium_mg;
    }

    public void setSodium_mg(int sodium_mg) {
        this.sodium_mg = sodium_mg;
    }

    public int getPotassium_g() {
        return potassium_g;
    }

    public void setPotassium_g(int potassium_g) {
        this.potassium_g = potassium_g;
    }

    public int getProtein_g() {
        return protein_g;
    }

    public void setProtein_g(int protein_g) {
        this.protein_g = protein_g;
    }

    public int getPhosphours_g() {
        return phosphours_g;
    }

    public void setPhosphours_g(int phosphours_g) {
        this.phosphours_g = phosphours_g;
    }
}
