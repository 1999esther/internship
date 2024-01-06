package com.esther.internship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Data //instead of setters and getters

@Entity // Maps to this class to the database
public class Users {

    @Id // marks id as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //shows that id is uniquely incremented since it's a primary key
    private Integer id;
    private String name;
    private String email;
    private String password;

}
