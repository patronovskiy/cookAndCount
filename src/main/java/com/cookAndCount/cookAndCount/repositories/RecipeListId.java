package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Repository
public interface RecipeListId extends CrudRepository<RecipeList, Long> {
//    List<RecipeList> findByRecipeListName(String recipeListName);

    RecipeList findById(long Id);

    List<RecipeList> findAll();
}
