package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.lang.String.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "json", name = "service")
public class Service {
    @Id
    @Column(name = "Id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type type;

    @ManyToMany( mappedBy = "services", cascade = CascadeType.ALL)
    private List<Attraction> attractions;

    public Service(Long id, String description, Type type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public Service(long l, String asdasd) {
    }
}


