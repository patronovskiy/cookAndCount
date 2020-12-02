package com.cookAndCount.cookAndCount;

import java.util.List;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
@Controller
public class TestingController {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping()
    public String main(Map<String, Object> model) {
        List<FoodItem> foodItems = foodItemRepository.findAll();

        for (FoodItem foodItem : foodItems) {
            System.out.println(foodItem.getFoodItemName());
        }

        model.put("foodItems", foodItems);
        return "main";
    }

    @PostMapping
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

}
