package com.example.demo.Repository;

import com.example.demo.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    Optional<Food> findByFoodName(String foodname);
}
