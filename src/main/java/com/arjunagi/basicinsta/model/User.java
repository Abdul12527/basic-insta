package com.arjunagi.basicinsta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Range(min = 10,max = 100)
    private Integer age;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Column(unique = true)
    private String email;
  //  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=!*])(?=\\\\S+$).{8,}$\n")
    private String password;
    @Size(min = 10,max = 10)
    private String phoneNumber;
}
