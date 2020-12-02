package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

public interface RecipeListId extends CrudRepository<RecipeList, Long> {
//    List<RecipeList> findByRecipeListName(String recipeListName);

    RecipeList findById(long Id);

    List<RecipeList> findAll();
}
