package com.cookAndCount.cookAndCount.repositories;

import java.util.ArrayList;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import org.springframework.data.repository.CrudRepository;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

public interface RecipeListRepository extends CrudRepository<RecipeList, Long> {

    ArrayList<RecipeList> findAllByOwnerId(Long ownerId);

    boolean existsByOwnerId(Long ownerId);
}
