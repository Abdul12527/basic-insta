package com.arjunagi.basicinsta.repo;

import com.arjunagi.basicinsta.model.User;
import com.arjunagi.basicinsta.model.UserAuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAuthRepo extends JpaRepository<UserAuthToken,Integer> {
    UserAuthToken findByUser(User user);

    UserAuthToken findByValue(String tokenValue);
}
