package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String name;

    private String category;

    private String brand;

    private String type;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Product() {}

}
