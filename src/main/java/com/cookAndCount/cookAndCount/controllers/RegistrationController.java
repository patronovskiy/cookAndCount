package com.cookAndCount.cookAndCount.controllers;

import java.util.Collections;
import java.util.Map;
import com.cookAndCount.cookAndCount.domain.RecipeList;
import com.cookAndCount.cookAndCount.domain.Role;
import com.cookAndCount.cookAndCount.domain.UserAccount;
import com.cookAndCount.cookAndCount.repositories.RecipeListRepository;
import com.cookAndCount.cookAndCount.repositories.UserAccountRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private RecipeListRepository recipeListRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUserAccount(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password,
                                 @RequestParam(name = "email") String email,
                                 Map<String, Object> model) {

        UserAccount userFromDb = userAccountRepository.findByUsername(username);

        if (userFromDb != null) {
            model.put("message", "Пользователь с таким именем уже существует");
            return "registration";
        }

        UserAccount newUser = new UserAccount(username, passwordEncoder.encode(password), email);
        newUser.setIsActive(true);
        newUser.setRoles(Collections.singleton(Role.USER));
        RecipeList recipeList = new RecipeList();
        recipeListRepository.save(recipeList);
        newUser.setRecipeList(recipeList);
        userAccountRepository.save(newUser);

        return "redirect:/login";
    }

}
