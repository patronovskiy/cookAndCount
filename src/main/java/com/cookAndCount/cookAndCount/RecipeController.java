package com.cookAndCount.cookAndCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeCreationDto;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.FoodItemsListRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
//@Controller
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FoodItemsListRepository foodItemsListRepository;

    @Autowired
    FoodItemRepository foodItemRepository;



    @PostMapping("/addRecipe")
    public String addRecipe(@ModelAttribute ("foodItems") ArrayList<FoodItem> foodItems,
                            @RequestParam (name="recipeName", required = true) String recipeName,
                            @RequestParam (name="addProductCheckbox", required = true) long[] productCheckboxes,
                            @RequestParam (name="quantityInput", required = true) String[] quantityInputs,
                            @RequestParam (name="recipeDescription", required = false) String recipeDescription,
                            Model model) {



        ArrayList<FoodItemsList> ingredients = new ArrayList<>();

//        for (FoodItem foodItem : foodItems) {
//            for (int i = 0; i < productCheckboxes.length; i++) {
//                if(foodItem.getFoodItemId() == productCheckboxes[i]) {
//                    FoodItemsList foodItemsList = new FoodItemsList(foodItem, Integer.parseInt(quantityInputs[i]));
//                    foodItemsListRepository.save(foodItemsList);
//                    ingredients.add(foodItemsList);
//                }
//            }
//        }

        //todo неправильно обрабатываются количества ингридиентов, если выбраны не все
        for (int i = 0; i < productCheckboxes.length; i++) {
            FoodItem foodItem = foodItemRepository.findById(productCheckboxes[i]);
            FoodItemsList foodItemsList= new FoodItemsList(foodItem, Integer.parseInt(quantityInputs[i]));
            foodItemsListRepository.save(foodItemsList);
            ingredients.add(foodItemsList);
        }

        Recipe recipe = new Recipe(recipeName, recipeDescription, ingredients);
        recipeRepository.save(recipe);

        return "redirect:/products";
    }

}
