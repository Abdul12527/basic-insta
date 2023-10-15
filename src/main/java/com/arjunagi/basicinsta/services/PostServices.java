package com.arjunagi.basicinsta.services;

import com.arjunagi.basicinsta.model.Post;
import com.arjunagi.basicinsta.model.UserAuthToken;
import com.arjunagi.basicinsta.model.dto.AuthInpDto;
import com.arjunagi.basicinsta.model.dto.PostDto;
import com.arjunagi.basicinsta.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServices {
    @Autowired
    private IPostRepo postRepo;
    @Autowired
    UserAuthServices userAuthServices;

    public String createPost(PostDto postDto) {
        UserAuthToken userAuthToken=userAuthServices.getTokenIfValid(postDto.getAuthInpDto());
        if(userAuthToken!=null){
            Post post=new Post(postDto.getData(),userAuthToken.getUser());
            postRepo.save(post);
            return "posted sucessfully";
        }
        return "wrong credentials";
    }

    public String updateThePost(Integer postId, AuthInpDto authInpDto, String data) {
        UserAuthToken userAuthToken=userAuthServices.getTokenIfValid(authInpDto);
        if(userAuthToken==null)return "don't have authority to update";
        Post post=postRepo.findById(postId).orElseThrow();
        if(userAuthToken.getUser().equals(post.getUser())){
            post.setPostData(data);
            post.setUpdationTime(LocalDateTime.now());
            postRepo.save(post);
            return "updated sucessfully";
        }
        return "not have authority";
    }
}
