package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "json", name = "attractions")
public class Attraction {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    TypeAttraction type;

    public Attraction() {
    }

    public Attraction(Long id, String name, String type) {
        this.id=id;
        TypeAttraction.valueOf(type);
        this.name = name;
    }

    public TypeAttraction getType() {
        return type;
    }

    public void setType(TypeAttraction type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

enum TypeAttraction {
    house("Белый дом"),
    garden("сад"),
    square("площадь");

    String s;

    TypeAttraction(String s) {
        this.s = s;
    }

    public String getInstance() {
        return s;
    }
}