package com.cookAndCount.cookAndCount.domain;

import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

//вспомогательный класс для сохренанения списка ингредиентов из формы
public class RecipeCreationDto {
    private List<FoodItemsList> ingredients;

    public RecipeCreationDto(List<FoodItemsList> foodItemsLists) {
        this.ingredients = foodItemsLists;
    }

    public RecipeCreationDto() {
    }

    public List<FoodItemsList> getFoodItemsLists() {
        return ingredients;
    }

    public void setFoodItemsLists(List<FoodItemsList> foodItemsLists) {
        this.ingredients= foodItemsLists;
    }

    public void addIngredient(FoodItemsList foodItemsList) {
        ingredients.add(foodItemsList);
    }



}
