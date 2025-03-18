package com.example.attraction.controllers;

import com.example.attraction.entity.Attraction;
import com.example.attraction.service.AttractionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/attraction")
    public class AttractionController {
    private AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping ("/find/{id}")
    public Optional<Attraction> findById(@PathVariable Long id){
    return attractionService.findById(id);
    }

    @GetMapping ("/change_name/")
    public Attraction changeById(@RequestParam Long id, @RequestParam String name ){
    return attractionService.changeById(id, name);
    }

    @DeleteMapping("/del/{id}")
    public String deleteById(@PathVariable Long id){
    return attractionService.deleteById(id);
    }

    @GetMapping ("save/")
    public Optional<Attraction> findById(@RequestParam Long id, @RequestParam (defaultValue = "noname") String name,@RequestParam (defaultValue = "дом") String type){
    return attractionService.save(id, name, type);
    }
}
