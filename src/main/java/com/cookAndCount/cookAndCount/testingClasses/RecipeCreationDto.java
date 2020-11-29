package com.cookAndCount.cookAndCount.testingClasses;

import java.util.List;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;

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
