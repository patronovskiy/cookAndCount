package com.cookAndCount.cookAndCount.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import com.cookAndCount.cookAndCount.domain.Recipe;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

public interface RecipeListRepository extends CrudRepository<RecipeList, Long> {

//    ArrayList<RecipeList> findAllByOwnerId(Long ownerId);

    HashSet<RecipeList> findAllByOwnerId(Long ownerId);
    HashSet<RecipeList> findAllByRecipe(Recipe recipe);

    boolean existsByOwnerId(Long ownerId);
}
