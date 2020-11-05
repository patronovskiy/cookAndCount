package com.cookAndCount.cookAndCount.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recipeId;

    private String recipeName;

    //суммарное количество КБЖУ
    private int sumCalories = 0;
    private int sumProtein = 0;
    private int sumFat = 0;
    private int sumCarbohydrates = 0;

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



    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getSumCalories() {
        return sumCalories;
    }

    public void setSumCalories(int sumCalories) {
        this.sumCalories = sumCalories;
    }

    public int getSumProtein() {
        return sumProtein;
    }

    public void setSumProtein(int sumProtein) {
        this.sumProtein = sumProtein;
    }

    public int getSumFat() {
        return sumFat;
    }

    public void setSumFat(int sumFat) {
        this.sumFat = sumFat;
    }

    public int getSumCarbohydrates() {
        return sumCarbohydrates;
    }

    public void setSumCarbohydrates(int sumCarbohydrates) {
        this.sumCarbohydrates = sumCarbohydrates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
