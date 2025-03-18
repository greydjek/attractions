package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema= "json", name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @OneToMany()
    @JoinColumn(name = "id")
    private List<Attraction> attractions= new ArrayList<Attraction>();

//    @Column(name = "building")
    private String building;

//    @Column(name = "street")
    private String street;

//    @Column(name = "region")
    private String region;

//    @Column(name = "longitude")
    private Double longitude;//долгота

//    @Column(name = "width")
    private Double width;

//    @Column(name = "address")
    private String address;

//    @Column(name = "index")
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address() {
    }
}
