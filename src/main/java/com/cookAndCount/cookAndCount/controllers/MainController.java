package com.cookAndCount.cookAndCount.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.domain.QuantityHandler;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import com.cookAndCount.cookAndCount.domain.UserAccount;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.FoodItemsListRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeListRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import com.cookAndCount.cookAndCount.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class MainController {

    //Вспомогательные переменные
    int ingredientsCount = 10;

    //репозитории для доступа к БД
    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    FoodItemsListRepository foodItemsListRepository;
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    RecipeListRepository recipeListRepository;

    //отображение главной страницы
    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        ProductsController.getFoodItems(foodItemRepository, model);

        getRecipesFromList(model);

        //создание пустого рецепта и помещение в model
        Recipe recipe = new Recipe("", "", new ArrayList<FoodItemsList>());
        model.put("recipe", recipe);
        ArrayList<FoodItemsList> foodItemsLists = new ArrayList<>();
        for (int i = 0; i < ingredientsCount; i++) {
            foodItemsLists.add(new FoodItemsList());
        }
        model.put("foodItemLists", foodItemsLists);

        return "main";
    }

    @GetMapping("/")
    public String main() {
        return "redirect:/main";
    }

    //методы для отображения элементов на главной странице

    //обработка форм главной страницы
    //добавление продукта
    @PostMapping("/addFoodItem")
    public String addFoodItem(@RequestParam String foodItemName,
                              @RequestParam String calories,
                              @RequestParam String protein,
                              @RequestParam String fat,
                              @RequestParam String carbohydrates,
                              Map<String, Object> model) {

        if(foodItemRepository.findByFoodItemName(foodItemName) == null) {
            FoodItem foodItem = new FoodItem(foodItemName,
                QuantityHandler.parseQuantity(calories),
                QuantityHandler.parseQuantity(protein),
                QuantityHandler.parseQuantity(fat),
                QuantityHandler.parseQuantity(carbohydrates));

            foodItemRepository.save(foodItem);
        } else {
            System.out.println("Такой продукт уже есть");
        }

        //обновляем главную страницу
        return "redirect:/main";
    }

    @PostMapping("/addRecipe")
    public String addRecipeTest(@RequestParam (name="recipeName") String recipeName,
                                @RequestParam (name="description") String description,
                                @RequestParam (name="foodItemName") String[] foodItemNames,
                                @RequestParam (name="foodItemQuantity") String[] foodItemQuantities,
                                Map<String, Object> model) {

        ArrayList<FoodItemsList> foodItemsLists = new ArrayList<>();
        for (int i = 0; i < foodItemNames.length; i ++) {
            if(foodItemNames[i].length() > 0 && foodItemQuantities[i].length() > 0) {
                try{
                    FoodItem foodItem = foodItemRepository.findByFoodItemName(foodItemNames[i]);
                    FoodItemsList foodItemsList = new FoodItemsList(foodItem, Integer.parseInt(foodItemQuantities[i]));
                    foodItemsListRepository.save(foodItemsList);
                    foodItemsLists.add(foodItemsList);
                } catch (Exception er) {
                    return "errorNoProduct";
                }
            }
        }
        Recipe recipe = new Recipe(recipeName, description, foodItemsLists);
        recipeRepository.save(recipe);

        //при добавлении пользователем рецепта, этот рецепт автоматически добавляется в список пользователя
        //todo - вынести в отдльный метод добавление в список
        String username = LoginController.getCurrentUsername();
        UserAccount user = userAccountRepository.findByUsername(username);
        Long userId = user.getUserId();
        RecipeList recipeList = new RecipeList();
        recipeList.setOwnerId(userId);
        recipeList.setRecipeListName(RecipeList.DEFAULT_RECIPE_LIST_NAME);
        recipeList.setRecipe(recipe);
        recipeListRepository.save(recipeList);

        return "redirect:/main";
    }

    //ПОИСК РЕЦЕПТОВ И ПРОДУКТОВ
    //поиск рецептов по части названия
    @PostMapping("/searchRecipeByName")
    public String searchRecipeByName(@RequestParam ("recipeName") String recipeName,
                                     Map<String, Object> model) {

        ArrayList<Recipe> recipes = recipeRepository.findAllByPartOfName(recipeName);
        model.put("searchRecipeName", recipeName);
        model.put("searchRecipes", recipes);

        return "searchRecipe";
    }

    //поиск продукта по части названия
    @PostMapping("/searchFoodItemByName")
    public String searchFoodItemByName(@RequestParam ("foodItemName") String foodItemName,
                                     Map<String, Object> model) {

        ArrayList<FoodItem> foodItems = foodItemRepository.findAllByPartOfName(foodItemName);
        model.put("searchFoodItemName", foodItemName);
        model.put("searchFoodItems", foodItems);

        return "searchFoodItem";
    }


    @GetMapping("/viewRecipe")
    public String viewRecipe(@RequestParam ("enteredRecipeId") String enteredId,
                             Map<String, Object> model) {
        Recipe foundRecipe = recipeRepository.findById(Long.parseLong(enteredId));
        ArrayList<FoodItem> recipeFoodItems = new ArrayList<>();
        for (FoodItemsList foodItemsList : foundRecipe.getFoodItemsLists()) {
            FoodItem foodItem = foodItemRepository.findById(foodItemsList.getFoodItemId());
            recipeFoodItems.add(foodItem);
        }
        model.put("recipeFoodItems", recipeFoodItems);
        model.put("foundRecipe", foundRecipe);
        model.put("foodItemRepository", foodItemRepository);
        return "viewRecipe";
    }

    public void getRecipesFromList(Map<String, Object> model) {
        String username = LoginController.getCurrentUsername();
        UserAccount user = userAccountRepository.findByUsername(username);
        Long userId = user.getUserId();

        HashSet<RecipeList> recipeLists = recipeListRepository.findAllByOwnerId(userId);
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (RecipeList recipeList : recipeLists) {
            Recipe recipe = recipeList.getRecipe();
            recipes.add(recipe);
        }
        model.put("userRecipes", recipes);

    }

    @GetMapping("/viewFoodItem")
    public String viewFoodItem(@RequestParam ("enteredFoodItemId") String enteredFoodItemId,
                             Map<String, Object> model) {
        FoodItem foundFoodItem = foodItemRepository.findById(Long.parseLong(enteredFoodItemId));

        model.put("foundFoodItem", foundFoodItem);
        model.put("foodItemRepository", foodItemRepository);
        return "viewFoodItem";
    }

}
