package com.example.attraction.dto;

import com.example.attraction.entity.Service;
import com.example.attraction.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto{
    private Long id;
    private String description;
    Type type;
}
