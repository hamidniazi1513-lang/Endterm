package com.hamidniazi.endterm_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users") // This tells the DB to name the table "users"
@Data // Lombok: Generates Getters, Setters, toString automatically
@NoArgsConstructor // Lombok: Generates empty constructor
@AllArgsConstructor // Lombok: Generates constructor with all args
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    private String role; // e.g., "ADMIN" or "STUDENT"
}