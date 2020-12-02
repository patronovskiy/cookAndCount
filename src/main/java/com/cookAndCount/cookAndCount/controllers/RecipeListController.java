package com.cookAndCount.cookAndCount.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Controller
public class RecipeListController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    RecipeListRepository recipeListRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @PostMapping("/addRecipeToList")
    public String addRecipeToList(@RequestParam(name="addingRecipeId") String addingRecipeId) {
        String username = LoginController.getCurrentUsername();
        UserAccount user = userAccountRepository.findByUsername(username);
        Long userId = user.getUserId();

        Recipe recipe = recipeRepository.findById(Long.parseLong(addingRecipeId));
        RecipeList recipeList = new RecipeList();
        recipeList.setOwnerId(userId);
        recipeList.setRecipeListName(RecipeList.DEFAULT_RECIPE_LIST_NAME);

        recipeList.setRecipe(recipe);
        recipeListRepository.save(recipeList);

        return "redirect:/main";
    }

}
