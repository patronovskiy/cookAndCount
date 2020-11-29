package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {

    ArrayList<Recipe> findByRecipeName(String recipeName);

    Recipe findById(long Id);

    ArrayList<Recipe> findAll();

    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE CONCAT('%',UPPER(:recipeName),'%')")
    ArrayList<Recipe> findAllByPartOfName(@Param("recipeName") String recipeName);


}
