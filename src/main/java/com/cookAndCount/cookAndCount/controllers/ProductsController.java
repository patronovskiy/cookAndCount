package com.cookAndCount.cookAndCount.controllers;

import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Controller
public class ProductsController {
    @Autowired
    FoodItemRepository foodItemRepository;

    @GetMapping("/products")
    public String viewProducts(Map<String, Object> model) {
        getFoodItems(foodItemRepository, model);
        return "foodItem";
    }

    //отображение продуктов из БД
    public static void getFoodItems(FoodItemRepository foodItemRepository, Map<String, Object> model) {
        List<FoodItem> foodItems = foodItemRepository.findAll();
        model.put("foodItems", foodItems);
    }
}
