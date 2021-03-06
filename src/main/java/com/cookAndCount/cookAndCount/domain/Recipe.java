package com.cookAndCount.cookAndCount.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recipeId;

    private String recipeName;

    //суммарное количество КБЖУ
    private double sumCalories = 0;
    private double sumProtein = 0;
    private double sumFat = 0;
    private double sumCarbohydrates = 0;

    private String description;

    @OneToMany(targetEntity = FoodItemsList.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_fk", referencedColumnName = "recipeId")
    private List<FoodItemsList> foodItemsLists;

    public Recipe() {
    }

    public Recipe(String recipeName, String description, List<FoodItemsList> ingredients){
        this.recipeName = recipeName;
        this.description = description;
        this.foodItemsLists = ingredients;

        for (FoodItemsList ingredient : ingredients) {
            this.sumCalories += ingredient.getCalories();
            this.sumProtein += ingredient.getProtein();
            this.sumFat += ingredient.getFat();
            this.sumCarbohydrates += ingredient.getCarbohydrates();
        }
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public double getSumCalories() {
        return (Math.round(sumCalories * 100)/100.0);
    }

    public void setSumCalories(double sumCalories) {
        this.sumCalories = sumCalories;
    }

    public double getSumProtein() {
        return (Math.round(sumProtein * 100)/100.0);
    }

    public void setSumProtein(double sumProtein) {
        this.sumProtein = sumProtein;
    }

    public double getSumFat() {
        return (Math.round(sumFat * 100)/100.0);
    }

    public void setSumFat(double sumFat) {
        this.sumFat = sumFat;
    }

    public double getSumCarbohydrates() {
        return (Math.round(sumCarbohydrates * 100)/100.0);
    }

    public void setSumCarbohydrates(double sumCarbohydrates) {
        this.sumCarbohydrates = sumCarbohydrates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodItemsList> getFoodItemsLists() {
        return foodItemsLists;
    }

    public void setFoodItemsLists(List<FoodItemsList> foodItemsLists) {
        this.foodItemsLists = foodItemsLists;
    }
}
