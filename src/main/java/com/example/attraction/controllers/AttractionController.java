package com.example.attraction.controllers;

import com.example.attraction.entity.Attraction;
import com.example.attraction.service.AttractionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
@RequiredArgsConstructor
public class AttractionController {
private AttractionService attractionService;
    @GetMapping ("attraction_find/{id}")
    public Optional<Attraction> findById(@PathVariable Long id){
    return attractionService.findById(id);
    }

    @GetMapping ("attraction_change_name/")
    public Attraction changeById(@RequestParam Long id, @RequestParam String name ){
    return attractionService.changeById(id, name);
    }

    @DeleteMapping("attraction_del/{id}")
    public String deleteById(@PathVariable Long id){
    return attractionService.deleteById(id);
    }

    @GetMapping ("attraction_find/")
    public Optional<Attraction> findById(@RequestParam String name,){
    return attractionService.save(name);
    }
}
