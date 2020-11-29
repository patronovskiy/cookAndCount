package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

    List<UserAccount> findByEmail(String email);

    UserAccount findById(long Id);

    List<UserAccount> findAll();
}
