package com.cookAndCount.cookAndCount.repositories;

import com.cookAndCount.cookAndCount.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

    List<UserAccount> findByEmail(String email);

    UserAccount findById(long Id);

    List<UserAccount> findAll();
}
