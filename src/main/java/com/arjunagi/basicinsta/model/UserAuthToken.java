package com.arjunagi.basicinsta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserAuthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;
    private LocalDateTime creationTime;
    @OneToOne
    private User user;

    public  UserAuthToken(User user){
        this.value=value;
        this.user=user;
        creationTime=LocalDateTime.now();
        value= UUID.randomUUID().toString();
    }
}
