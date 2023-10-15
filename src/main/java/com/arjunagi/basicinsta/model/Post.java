package com.arjunagi.basicinsta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String postData;
    private LocalDateTime creationTime;
    private LocalDateTime updationTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    public Post(String postData,User user){
        this.postData=postData;
        this.user=user;
        creationTime=LocalDateTime.now();
        updationTime=LocalDateTime.now();
    }

}
