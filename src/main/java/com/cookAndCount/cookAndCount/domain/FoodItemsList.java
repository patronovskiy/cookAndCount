package com.cookAndCount.cookAndCount.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Entity
public class FoodItemsList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long foodItemListId;

    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    private long foodItemId;

    private int foodItemQuantity;

    public FoodItemsList() {
    }

    public FoodItemsList(FoodItem foodItem, int foodItemQuantity) {
        foodItem.addFoodItemList(this);
        this.foodItemId = foodItem.getFoodItemId();
        this.calories = foodItem.getCalories()*foodItemQuantity/100;
        this.fat = foodItem.getFat()*foodItemQuantity/100;
        this.carbohydrates = foodItem.getCarbohydrates()*foodItemQuantity/100;
        this.protein = foodItem.getProtein()*foodItemQuantity/100;
        this.foodItemQuantity = foodItemQuantity;
    }

    public Long getFoodItemListId() {
        return foodItemListId;
    }

    public void setFoodItemListId(Long foodItemListId) {
        this.foodItemListId = foodItemListId;
    }

    public int getFoodItemQuantity() {
        return foodItemQuantity;
    }

    public void setFoodItemQuantity(int foodItemQuantity) {
        this.foodItemQuantity = foodItemQuantity;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public FoodItem getFoodItem(FoodItemRepository foodItemRepository) {
        FoodItem foodItem = foodItemRepository.findById(this.foodItemId);
        return foodItem;
    }

}