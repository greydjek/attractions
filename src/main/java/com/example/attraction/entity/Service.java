package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static java.lang.String.*;

@Entity
@Data
@Table(schema = "json", name = "service")
public class Service {
    @Id
    @Column(name = "Id", nullable = false, insertable=false, updatable=false)
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
    @JoinTable(schema = "json", name = "service_attraction",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id"))
    private List<Attraction> attractions;

    public Service(Integer number, String description, String type, Long id) {
        this.address.setId(id);
        this.number = number;
        this.description = description;
        Type.valueOf(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
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
