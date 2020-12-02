package com.cookAndCount.cookAndCount.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

//класс, описывающий продукт
@Entity
public class FoodItem {
    //первичный ключ - id - генерируется автоматически
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long foodItemId;

    //наименование продукта
    private String foodItemName;
    //КБЖУ продукта на 100 г
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;
    private int glycemicIndex;

    @OneToMany(targetEntity = FoodItemsList.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "foodItem_fk", referencedColumnName = "foodItemId")
    private List<FoodItemsList> foodItemsLists;

    protected FoodItem() {
    }

    public FoodItem(String foodItemName, double calories, double protein, double fat, double carbohydrates) {
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

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
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

    public void setCalories(double calories) {
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

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public List<FoodItemsList> getFoodItemsLists() {
        return foodItemsLists;
    }

    public void setFoodItemsLists(List<FoodItemsList> foodItemsLists) {
        this.foodItemsLists = foodItemsLists;
    }

    public void addFoodItemList(FoodItemsList foodItemsList) {
        this.foodItemsLists.add(foodItemsList);
    }

}
