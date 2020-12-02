package com.cookAndCount.cookAndCount.domain;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public class RecipeList {

    public static final String DEFAULT_RECIPE_LIST_NAME = "Мой список";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recipeListId;

    private String recipeListName;
    private Long ownerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    public RecipeList() {
    }

    public RecipeList(String recipeListName){
        this.recipeListName = recipeListName;
    }

    public Long getRecipeListId() {
        return recipeListId;
    }

    public void setRecipeListId(Long recipeListId) {
        this.recipeListId = recipeListId;
    }

    public String getRecipeListName() {
        return recipeListName;
    }

    public void setRecipeListName(String recipeListName) {
        this.recipeListName = recipeListName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Long getRecipeId() {
        return this.recipe.getRecipeId();
    }

}
