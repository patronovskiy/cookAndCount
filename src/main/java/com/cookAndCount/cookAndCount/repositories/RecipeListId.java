package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeListId extends CrudRepository<RecipeList, Long> {
//    List<RecipeList> findByRecipeListName(String recipeListName);

    RecipeList findById(long Id);

    List<RecipeList> findAll();

}
