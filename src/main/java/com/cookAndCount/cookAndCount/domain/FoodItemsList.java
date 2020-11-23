package com.cookAndCount.cookAndCount.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */



@Entity
public class FoodItemsList {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long foodItemListId;

//    @ManyToOne(targetEntity = FoodItem.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "foodItemList_fk", referencedColumnName = "foodItemId")
//    private FoodItem foodItem;

    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    private long foodItemId;

    private int foodItemQuantity;

//    //!!!
//    @ManyToOne
//    private FoodItem foodItem;

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
}

//встраиваемый класс для реализации составного ключа
//@Embeddable
//class FoodItemListId implements Serializable {
//    @OneToMany
//    @JoinColumn(name = "")
//    private Collection<FoodItem>;
//    Long recipeId;

//    public FoodItemListId() {
//    }
//
//    FoodItemListId(Long foodItemId, Long recipeId) {
//        this.foodItemId = foodItemId;
//        this.recipeId=recipeId;
//    }
//};