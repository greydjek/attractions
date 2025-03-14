package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Service")
public class Service {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type type;

    @ManyToOne
    @JoinColumn(name = "id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "service_attraction",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id"))
    private List<Attraction> attractions;
}

enum Type {
    GID("гид"),
    AUTOEXPRESS("авто прогулки"),
    FOOD("еда");
    String string;
    Type(String string){
        this.string= string;
    }

    public String getString() {
        return string;
    }
}
