package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Repository
public interface FoodItemsListRepository extends CrudRepository<FoodItemsList, Long> {
}
