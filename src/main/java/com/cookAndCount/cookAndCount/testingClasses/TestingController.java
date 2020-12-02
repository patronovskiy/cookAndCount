package com.cookAndCount.cookAndCount.testingClasses;

import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
//@Controller
public class TestingController {

    //добавление продуктов
    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping()
    public String main(Map<String, Object> model) {


        List<FoodItem> foodItems = foodItemRepository.findAll();

        for (FoodItem foodItem : foodItems) {
            System.out.println(foodItem.getFoodItemName());
        }
        model.put("foodItems", foodItems);

        return "main";
    }

    @PostMapping()
    public String add(@RequestParam String foodItemName,
                      @RequestParam String calories,
                      @RequestParam String protein,
                      @RequestParam String fat,
                      @RequestParam String carbohydrates,
                      Map<String, Object> model) {

        FoodItem foodItem = new FoodItem(foodItemName,
                Integer.parseInt(calories),
                Integer.parseInt(protein),
                Integer.parseInt(fat),
                Integer.parseInt(carbohydrates));

        foodItemRepository.save(foodItem);

        return "main";
    }

    //добавление рецептов
    @Autowired
    private RecipeRepository recipeRepository;

    //для перехода к вводу рецепта надо перейти на http://localhost:8080/mainRecipe
    @GetMapping("/mainRecipe")
    public String mainRecipe(Map<String, Object> model) {
        List<Recipe> recipes = recipeRepository.findAll();

        for (Recipe recipe : recipes) {
            System.out.println(recipe.getRecipeName());
        }

        model.put("recipes", recipes);
        return "recipeInput";   //todo почему возвращает эту страницу?
    }

    @PostMapping("/mainRecipe")
    public String addRecipe(@RequestParam String recipeName,
                            @RequestParam String description,
                            Map<String, Object> model) {

//        Recipe recipe = new Recipe(recipeName, description);

//        recipeRepository.save(recipe);

        return "recipeInput";
    }
}
