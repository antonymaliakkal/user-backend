package com.ust.wastewarden.users.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String location;

    @Enumerated(EnumType.STRING)
    private Role role;

}
