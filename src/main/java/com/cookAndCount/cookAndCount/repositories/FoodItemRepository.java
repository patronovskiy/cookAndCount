package com.cookAndCount.cookAndCount.repositories;

import java.util.ArrayList;
import java.util.List;
import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {

    FoodItem findByFoodItemName(String foodItemName);

    FoodItem findById(long Id);

    List<FoodItem> findAll();

    @Query("SELECT r FROM FoodItem r WHERE UPPER(r.foodItemName) LIKE CONCAT('%',UPPER(:foodItemName),'%')")
    ArrayList<FoodItem> findAllByPartOfName(@Param("foodItemName") String foodItemName);


}
