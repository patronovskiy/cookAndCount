package com.cookAndCount.cookAndCount.domain;

import javax.persistence.*;

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
    private int sumCalories;
    private int sumProtein;
    private int sumFat;
    private int sumCarbohydrates;

    private String description;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "foodItemId")
//    private FoodItem foodItem;             // тут будет список, а не отдельный продукт


    public Recipe() {
    }

    public Recipe(String recipeName, String description){
        this.recipeName = recipeName;
        this.description = description;
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
