package com.arjunagi.basicinsta.services;

import com.arjunagi.basicinsta.model.User;
import com.arjunagi.basicinsta.model.UserAuthToken;
import com.arjunagi.basicinsta.model.dto.AuthInpDto;
import com.arjunagi.basicinsta.repo.IUserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServices {
    @Autowired
    private IUserAuthRepo userAuthRepo;

    public UserAuthToken getAuthToken(User user) {
        UserAuthToken userAuthToken= userAuthRepo.findByUser(user);
        if(userAuthToken!=null)return userAuthToken;
        userAuthToken = new UserAuthToken(user);
        userAuthRepo.save(userAuthToken);
        return userAuthToken;

    }

    public UserAuthToken getTokenIfValid(AuthInpDto authInpDto) {
        UserAuthToken userAuthToken = userAuthRepo.findByValue(authInpDto.getTokenValue());
        return userAuthToken.getUser().getEmail().equals(authInpDto.getEmail())?userAuthToken:null;
    }


    public void deleteAuthToken(UserAuthToken userAuthToken) {
        userAuthRepo.delete(userAuthToken);
    }
}
