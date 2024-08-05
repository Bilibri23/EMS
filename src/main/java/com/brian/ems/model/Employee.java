package com.brian.ems.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "employees")
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id",nullable = false, unique = true)
    private String email;
    //@Request body is what that accepts the json attributes and convert to back java objects
    //thus json attributes and java objects should be same
}
