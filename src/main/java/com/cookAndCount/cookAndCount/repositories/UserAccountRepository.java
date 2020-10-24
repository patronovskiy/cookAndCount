package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    List<UserAccount> findByUsername(String username);

    List<UserAccount> findByEmail(String email);

    UserAccount findById(long Id);

    List<UserAccount> findAll();
}
