package com.cookAndCount.cookAndCount.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.domain.FoodItemsTestingLoader;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.FoodItemsListRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
@Controller
public class MainController {

    //репозитории для доступа к БД
    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    FoodItemsListRepository foodItemsListRepository;

    //отображение главной страницы
    @GetMapping("main")
    public String main(Map<String, Object> model) {

        //загрузка продуктов в бд todo - удалить, это для отладки
        // boolean isProductsLoaded = false;
        //FoodItemsTestingLoader.fillFoodItemsDB(isProductsLoaded, foodItemRepository);

        getFoodItems(foodItemRepository, model);
        getRecipes(recipeRepository, model);

        return "main";
    }


    //методы для отображения элементов на главной странице
    //отображение продуктов из БД
    public void getFoodItems(FoodItemRepository foodItemRepository, Map<String, Object> model) {
        List<FoodItem> foodItems = foodItemRepository.findAll();

        for (FoodItem foodItem : foodItems) {
            System.out.println(foodItem.getFoodItemName());
        }
        model.put("foodItems", foodItems);
    }

    //отображение рецептов из БД
    public void getRecipes(RecipeRepository recipeRepository, Map<String, Object> model) {
        List<Recipe> recipes = recipeRepository.findAll();
        model.put("recipes", recipes);
    }

    //обработка форм главной страницы
    //добавление продукта
    @PostMapping("/addFoodItem")
    public String addFoodItem(@RequestParam String foodItemName,
                              @RequestParam String calories,
                              @RequestParam String protein,
                              @RequestParam String fat,
                              @RequestParam String carbohydrates,
                              Map<String, Object> model) {

        FoodItem foodItem = new FoodItem(foodItemName,
        Integer.parseInt(calories),
        Double.parseDouble(protein),
        Double.parseDouble(fat),
        Double.parseDouble(carbohydrates));

        foodItemRepository.save(foodItem);

        //обновляем главную страницу
        return "redirect:/main";
    }

    //добавление рецепта - выбор ингредиентов
    @PostMapping("/getIngredientsForAddingRecipe")
    public String addRecipe(@ModelAttribute("foodItems") ArrayList<FoodItem> foodItems,
                            @RequestParam (name="recipeName", required = true) String recipeName,
                            @RequestParam (name="addProductCheckbox", required = true) long[] productCheckboxes,
                            @RequestParam (name="recipeDescription", required = false) String recipeDescription,
                            Map<String, Object> model) {

        ArrayList<FoodItem> ingredients = new ArrayList<FoodItem>();

        for (long foodItemId : productCheckboxes) {
            ingredients.add(foodItemRepository.findById(foodItemId));
        }

        model.put("ingredients", ingredients);
        model.put("recipeName", recipeName);
        model.put("recipeDescription", recipeDescription);

        return "addRecipe";
    }

    @PostMapping("/addRecipeIngredients")
    public String addRecipe(@RequestParam Map<String,String> allParams,
                            @ModelAttribute("ingredients") ArrayList<FoodItem> ingredients,
                            @ModelAttribute ("recipeName") String recipeName,
                            @ModelAttribute ("recipeDescription") String recipeDescription,
                            Map<String, Object> model){

        List<FoodItemsList> foodItemsLists = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {
            int quantity = Integer.parseInt(allParams.get("quantity"+ingredients.get(i).getFoodItemId()));
            FoodItemsList foodItemsList= new FoodItemsList(ingredients.get(i), quantity);
            foodItemsListRepository.save(foodItemsList);
            System.out.println(foodItemsList.getCalories());
            foodItemsLists.add(foodItemsList);
        }

        Recipe recipe = new Recipe(recipeName, recipeDescription, foodItemsLists);
        recipeRepository.save(recipe);

        return "redirect:/main";
    }








}
