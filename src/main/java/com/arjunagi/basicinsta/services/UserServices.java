package com.arjunagi.basicinsta.services;

import com.arjunagi.basicinsta.model.User;
import com.arjunagi.basicinsta.model.UserAuthToken;
import com.arjunagi.basicinsta.model.dto.AuthInpDto;
import com.arjunagi.basicinsta.repo.IUserAuthRepo;
import com.arjunagi.basicinsta.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServices {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private UserAuthServices userAuthServices;

    public void registerUser(User user) {


        try {
            user.setPassword(PasswordEncryptor.encrypt(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        user.setId(null);
        userRepo.save(user);

    }
    private User getUserForValidEmailPassword(String email,String pass) throws NoSuchAlgorithmException {
        User user=userRepo.findFirstByEmail(email);
        if(user==null)return null;
        return user.getPassword().equals(PasswordEncryptor.encrypt(pass))?user:null;
    }

    public AuthInpDto signIn(String email, String password) {
        User user;
        try {
             user = getUserForValidEmailPassword(email,password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if(user==null)return null;
        UserAuthToken userAuthToken=userAuthServices.getAuthToken(user);
        return  new AuthInpDto(email,userAuthToken.getValue());


    }


    public String signOut(AuthInpDto authInpDto) {
        UserAuthToken userAuthToken=userAuthServices.getTokenIfValid(authInpDto);
        if(userAuthToken!=null){
            userAuthServices.deleteAuthToken(userAuthToken);
            return "logged out sucessfully";
        }
        return "wrong acess";
    }


}
