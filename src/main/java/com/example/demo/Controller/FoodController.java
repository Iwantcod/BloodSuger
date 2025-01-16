package com.example.demo.Controller;

import com.example.demo.DTO.FoodDTO;
import com.example.demo.Entity.Food;
import com.example.demo.Service.FoodService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFood(@ModelAttribute FoodDTO foodDTO) {
        try {
            return new ResponseEntity<>(foodService.addFood(foodDTO), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getFoodById(@PathVariable int id) {
//        Optional<FoodDTO> food = foodService.getFoodById(id);
//    }
}
