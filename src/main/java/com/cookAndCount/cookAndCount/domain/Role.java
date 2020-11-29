package com.cookAndCount.cookAndCount.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public enum Role implements GrantedAuthority {
    USER("USER"),
    ADMIN("ADMIN");

    String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
