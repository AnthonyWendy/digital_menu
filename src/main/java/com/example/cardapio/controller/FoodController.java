package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRequestDto;
import com.example.cardapio.food.FoodResponseDto;
import com.example.cardapio.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowCredentials = "*")
    @GetMapping
    public List<FoodResponseDto> getAll(){
        List<FoodResponseDto> foodList = repository.findAll().stream().map(FoodResponseDto::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowCredentials = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDto data){
        Food food  = new Food(data);
        repository.save(food);
        return;
    }

}
