package com.cookAndCount.cookAndCount.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
  * @author NuclearKat369
  * @link https://github.com/NuclearKat369
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    public static String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
