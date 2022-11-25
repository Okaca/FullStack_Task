package com.ekiptesin_ats.ats_rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   //getters for all fields, setters for all non-final fields
@AllArgsConstructor     //a constructor with one parameter for each field in your class will be generated
@NoArgsConstructor      //automatically generating a constructor with no parameters
@Entity                 //declaratively define how to map Java objects to relational database tables in a standard, portable way,
                        //This tells Hibernate to make a table out of this class
@Table(name = "CANDIDATES")
public class Candidate {

    @Id                 //primary key
    @GeneratedValue     //self generated and updated
    private int id;
    private String name;
    private String surname;
    private String email;
    private String notes;
    private String status;
}
