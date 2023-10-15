package com.arjunagi.basicinsta.repo;

import com.arjunagi.basicinsta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);
}
