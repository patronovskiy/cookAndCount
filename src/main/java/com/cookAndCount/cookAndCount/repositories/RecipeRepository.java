package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {

    List<Recipe> findByRecipeName(String recipeName);

    Recipe findById(long Id);

    List<Recipe> findAll();

}
