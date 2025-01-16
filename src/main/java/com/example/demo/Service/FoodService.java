package com.example.demo.Service;

import com.example.demo.DTO.FoodDTO;
import com.example.demo.Entity.Food;
import com.example.demo.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Convert Entity to DTO
    private FoodDTO toDTO(Food food) {
        FoodDTO dto = new FoodDTO();
        dto.setId(food.getId());
        dto.setFoodName(food.getFoodName());
        dto.setFoodCategory(food.getFoodCategory());
        dto.setIngredients(food.getIngredients());
        dto.setSodium_mg(food.getSodium_mg());
        dto.setPotassium_g(food.getPotassium_g());
        dto.setProtein_g(food.getProtein_g());
        dto.setPhosphours_g(food.getPhosphours_g());
        return dto;
    }

    public boolean addFood(FoodDTO foodDTO) throws IOException {
        if(foodRepository.existsByFoodName(foodDTO.getFoodName())) {
            return false;
        }

        try{
            Food food = new Food();
            byte[] imageBytes = foodDTO.getFoodImage().getBytes();

            food.setFoodName(foodDTO.getFoodName());
            food.setFoodCategory(foodDTO.getFoodCategory());
            food.setIngredients(foodDTO.getIngredients());
            food.setSodium_mg(foodDTO.getSodium_mg());
            food.setPotassium_g(foodDTO.getPotassium_g());
            food.setProtein_g(foodDTO.getProtein_g());
            food.setPhosphours_g(foodDTO.getPhosphours_g());
            // MultipartFile to byte[]
            if (foodDTO.getFoodImage() != null) {
                food.setFoodImage(foodDTO.getFoodImage().getBytes());
            }
            foodRepository.save(food);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FoodDTO getFoodById(int id) {
        Optional<Food> food = foodRepository.findById(id);
        return food.map(this::toDTO).orElse(null);
    }

    // Update
    public FoodDTO updateFood(int id, FoodDTO foodDTO) {
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isPresent()) {
            Food food = existingFood.get();
            food.setFoodName(foodDTO.getFoodName());
            food.setFoodCategory(foodDTO.getFoodCategory());
            food.setIngredients(foodDTO.getIngredients());
            food.setSodium_mg(foodDTO.getSodium_mg());
            food.setPotassium_g(foodDTO.getPotassium_g());
            food.setProtein_g(foodDTO.getProtein_g());
            food.setPhosphours_g(foodDTO.getPhosphours_g());

            // Update image if provided
            try {
                if (foodDTO.getFoodImage() != null) {
                    food.setFoodImage(foodDTO.getFoodImage().getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Food updatedFood = foodRepository.save(food);
            return toDTO(updatedFood);
        }
        return null;
    }


    public boolean deleteFood(int id) {
        if (!foodRepository.existsById(id)) {
            return false;
        } else {
            foodRepository.deleteById(id);
            return true;
        }
    }
}
