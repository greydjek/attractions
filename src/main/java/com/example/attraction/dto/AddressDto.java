package com.example.attraction.dto;

import com.example.attraction.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto{
    Long id;
    String building;
    String address;
}
