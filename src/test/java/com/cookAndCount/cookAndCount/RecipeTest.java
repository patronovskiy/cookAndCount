package com.cookAndCount.cookAndCount;

import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.domain.Recipe;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
@SpringBootTest
public class RecipeTest {

    @Test
    public void testRecipeCreating() {
        FoodItem milk = new FoodItem("milk", 52, 2.8, 2.5, 4.7);
        milk.setFoodItemId(0L);
        FoodItem eggs = new FoodItem("eggs", 160, 12.9, 11.6, 0.8);
        eggs.setFoodItemId(1L);
        FoodItemsList foodItemsList1 = new FoodItemsList(milk, 100);
        FoodItemsList foodItemsList2 = new FoodItemsList(eggs, 50);
        List<FoodItemsList> ingredients = Arrays.asList(foodItemsList1, foodItemsList2);
        Recipe recipe = new Recipe("omelet", "testing recipe", ingredients);

        assertEquals("omelet", recipe.getRecipeName());
        assertEquals("testing recipe", recipe.getDescription());
        //расчет с точностью до 0,5 ккал / г
        assertEquals("sum calories delta", 132, recipe.getSumCalories(), 0.5);
        assertEquals("sum protein delta", 9.25, recipe.getSumProtein(), 0.5);
        assertEquals("sum fat delta", 8.3, recipe.getSumFat(), 0.5);
        assertEquals("sum carbohydrates delta", 5.1, recipe.getSumCarbohydrates(), 0.5);
    }

}
