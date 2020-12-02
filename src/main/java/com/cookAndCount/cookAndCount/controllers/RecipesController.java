package com.cookAndCount.cookAndCount.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import com.cookAndCount.cookAndCount.domain.UserAccount;
import com.cookAndCount.cookAndCount.repositories.RecipeListRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import com.cookAndCount.cookAndCount.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Controller
public class RecipesController {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    RecipeListRepository recipeListRepository;

    @GetMapping("/viewAllRecipes")
    public String viewRecipes(Map<String, Object> model) {
        getRecipes(recipeRepository, model);

        String username = LoginController.getCurrentUsername();
        UserAccount user = userAccountRepository.findByUsername(username);
        ArrayList<RecipeList> recipeLists = recipeListRepository.findAllByOwnerId(user.getUserId());
        model.put("recipeLists", recipeLists);

        return "/recipes";
    }

    //отображение рецептов из БД
    public static void getRecipes(RecipeRepository recipeRepository, Map<String, Object> model) {
        List<Recipe> recipes = recipeRepository.findAll();
        model.put("recipes", recipes);
    }
}
