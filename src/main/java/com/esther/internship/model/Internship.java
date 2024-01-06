package com.esther.internship.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity


public class Internship {

    @Id // marks id as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //shows that id is uniquely incremented since it's a primary key
    private Integer id;
    private String fullname;
    private String email;
    private String phone;
    private String university;
    private String major;
    private String year;
    private String why;

    @ElementCollection
    private List <String> interests;

}
