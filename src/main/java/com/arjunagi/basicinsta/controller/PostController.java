package com.arjunagi.basicinsta.controller;

import com.arjunagi.basicinsta.model.dto.AuthInpDto;
import com.arjunagi.basicinsta.model.dto.PostDto;
import com.arjunagi.basicinsta.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostServices postServices;

    @PostMapping("user/post")
    public String createPost(@RequestBody PostDto postDto){
        return  postServices.createPost(postDto);
    }
    @PutMapping("/user/post/id/{postId}")
    public String updateThePost(@PathVariable Integer postId, @RequestBody AuthInpDto authInpDto, @RequestParam String data){
        return postServices.updateThePost(postId,authInpDto,data);
    }
}
