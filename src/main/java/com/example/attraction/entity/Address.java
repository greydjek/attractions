package com.example.attraction.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema = "json", name = "address")
@NoArgsConstructor
@AllArgsConstructor
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

}
