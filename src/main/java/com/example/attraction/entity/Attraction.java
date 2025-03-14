package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "attractions")
public class Attraction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    TypeAttraction type;
}

enum TypeAttraction {
    house("Белый дом"),
    garden("Адмиралтейский сад"),
    square("Красная площадь");

    String s;

    TypeAttraction(String s) {
        this.s = s;
    }

    public String getInstance() {
        return s;
    }
}