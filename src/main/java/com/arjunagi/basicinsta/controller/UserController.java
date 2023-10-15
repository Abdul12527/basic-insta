package com.arjunagi.basicinsta.controller;

import com.arjunagi.basicinsta.model.User;
import com.arjunagi.basicinsta.model.dto.AuthInpDto;
import com.arjunagi.basicinsta.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/user/signUp")
    public String registerUser(@RequestBody  User user){
        userServices.registerUser(user);
        return "added sucessfully";
    }

    @PostMapping("/user/signin")
    public AuthInpDto signIn(String email,String password){
        return userServices.signIn(email,password);
    }
    @DeleteMapping("user/signOut")
    public String signOut(AuthInpDto authInpDto){
        return userServices.signOut(authInpDto);
    }

}
