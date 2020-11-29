package com.cookAndCount.cookAndCount.testingClasses;

import java.util.ArrayList;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.testingClasses.RecipeCreationDto;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */


//@RequestMapping("/products")
//@Controller
public class FoodItemsController {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    //страница с таблицами - заполнение
    @GetMapping
    public String setProductsPage(Model model) {

        //fillFoodItemsDB();

        //получение списка продуктов
        ArrayList<FoodItem> foodItems = getProductsList();
        model.addAttribute("foodItems", foodItems);

        //создаем пустой список ингредиентов
        RecipeCreationDto addRecipeForm = new RecipeCreationDto();
        //на каждый отмеченный чекбокс создаем пустой ингредиент
        for(int i = 0; i < foodItems.size(); i++) {
            addRecipeForm.addIngredient(new FoodItemsList());
        }
        model.addAttribute("addRecipeForm", addRecipeForm);

        return "products";
    }

    public ArrayList getProductsList() {
        ArrayList<FoodItem> foodItems = foodItemRepository.findAll();
        return foodItems;
    }

    //todo убрать - для отладки
    public void fillFoodItemsDB(boolean isProductsLoaded) {
        if (!isProductsLoaded) {
            FoodItem foodItem1 = new FoodItem("молоко", 52, 2.8, 2.5, 4.7);
            FoodItem foodItem2 = new FoodItem("яйца куриные", 157, 12.7, 10.9, 0.7);
            FoodItem foodItem3 = new FoodItem("сыр голландский", 352, 26.0, 26.8, 0);

            foodItemRepository.save(foodItem1);
            foodItemRepository.save(foodItem2);
            foodItemRepository.save(foodItem3);

            System.out.println("продукты загружены в БД");
        }
    }
}
