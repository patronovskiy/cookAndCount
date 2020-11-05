package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import org.springframework.data.repository.CrudRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public interface FoodItemsListRepository extends CrudRepository<FoodItemsList, Long> {
}
