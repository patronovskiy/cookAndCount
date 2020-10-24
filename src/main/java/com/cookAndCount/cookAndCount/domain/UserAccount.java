package com.cookAndCount.cookAndCount.domain;

import javax.persistence.*;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long userId;

    //данные пользователя
    private String username;
    private String password;
    private String email;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeListId")
    private RecipeList recipeList;

    protected UserAccount() {
    }

    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RecipeList getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(RecipeList recipeList) {
        this.recipeList = recipeList;
    }
}
