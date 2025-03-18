package com.example.attraction.controllers;

import com.example.attraction.entity.Service;
import com.example.attraction.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/service")
public class ServiceController {
    private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/find/{id}")
    public Optional<Service> findById(@PathVariable Long id) {
        return serviceService.findById(id);
    }

    @PostMapping("/save")
    public Optional<Service> save(@RequestBody Service service
//            @RequestParam Integer number,
//            @RequestParam String description,
//            @RequestParam(defaultValue = "GID") String type,
//            @RequestParam Long id
    ) {
        return serviceService.save(service);
    }
}
