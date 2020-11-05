package com.cookAndCount.cookAndCount.repositories;

import java.util.ArrayList;
import java.util.List;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {

    ArrayList<FoodItem> findByFoodItemName(String foodItemName);

    FoodItem findById(long Id);

    ArrayList<FoodItem> findAll();

}
