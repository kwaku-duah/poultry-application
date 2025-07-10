package com.poultry.userservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class User {

    @Id
    private Long id;


    private String fullName;

    private String email;

    private String password;
}
