package com.cookAndCount.cookAndCount.domain;

import javax.persistence.*;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

@Entity
public class RecipeList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recipeListId;

    private String recipeListName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId")
    private Recipe recipe;


    public RecipeList() {
    }

    public RecipeList(String recipeListName){
        this.recipeListName = recipeListName;
    }




}
