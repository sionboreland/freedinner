package com.example.sms_spring_boot_asses.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

// @data is lombok annotation handles getters and setters
// @entity is a hibernate class use to map to database
// @Table entity will be represented in database with "user" name
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true,nullable = false,length = 100)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    //storing emum values in two ways first is ordinal numers 0 for USER 1 for ADMIN and the other is a string variable
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;

    // should always be transient so it wont be stored on the database it will be used only on, on th  fly instances
    @Transient
    private  String token;

}
