package com.cookAndCount.cookAndCount.controllers;

import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
@Controller
public class RecipesController {
    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public String viewRecipes(Map<String, Object> model) {
        getRecipes(recipeRepository, model);
        return "/recipes";
    }

    //отображение рецептов из БД
    public static void getRecipes(RecipeRepository recipeRepository, Map<String, Object> model) {
        List<Recipe> recipes = recipeRepository.findAll();
        model.put("recipes", recipes);
    }
}
