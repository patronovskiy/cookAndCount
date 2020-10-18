package com.cookAndCount.cookAndCount.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

//класс, описывающий продукт
@Entity
//@Table("foodItems")
public class FoodItem {
    //первичный ключ - id - генерируется автоматически
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long foodItemId;

    //наименование продукта
    private String foodItemName;
    //КБЖУ продукта на 100 г
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrates;

    private int glycemicIndex;

    protected FoodItem() {
    }

    public FoodItem(String foodItemName, int calories, int protein, int fat, int carbohydrates) {
        this.foodItemName = foodItemName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public void setGlycemicIndex(int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
