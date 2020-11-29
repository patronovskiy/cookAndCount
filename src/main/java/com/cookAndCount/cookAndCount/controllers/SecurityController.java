package com.cookAndCount.cookAndCount.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */
@Controller
public class SecurityController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
