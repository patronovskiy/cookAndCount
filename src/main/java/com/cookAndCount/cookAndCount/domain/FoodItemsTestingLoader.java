package com.cookAndCount.cookAndCount.domain;

import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

//todo класс для отладки
public class FoodItemsTestingLoader {
    public static void fillFoodItemsDB(boolean isProductsLoaded, FoodItemRepository foodItemRepository) {
        if (!isProductsLoaded) {
            FoodItem foodItem1 = new FoodItem("молоко", 52, 2.8, 2.5, 4.7);
            FoodItem foodItem2 = new FoodItem("яйца куриные", 157, 12.7, 10.9, 0.7);
            FoodItem foodItem3 = new FoodItem("сыр голландский", 352, 26.0, 26.8, 0);

            foodItemRepository.save(foodItem1);
            foodItemRepository.save(foodItem2);
            foodItemRepository.save(foodItem3);

            System.out.println("продукты загружены в БД");
            isProductsLoaded = true;
        }
    }
}
