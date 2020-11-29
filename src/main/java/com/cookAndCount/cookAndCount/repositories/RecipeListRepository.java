package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public interface RecipeListRepository extends CrudRepository<RecipeList, Long> {
}
