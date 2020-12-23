package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

    List<UserAccount> findByEmail(String email);

    UserAccount findById(long Id);

    List<UserAccount> findAll();
}
