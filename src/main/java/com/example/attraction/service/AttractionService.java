package com.example.attraction.service;

import com.example.attraction.entity.Attraction;
import com.example.attraction.repository.AttractionRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.util.Optional;

@Service
@Data
public class AttractionService {
private AttractionRepository attractionRepository;
@Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public Optional<Attraction> findById(Long id) {
    return attractionRepository.findById(id);
    }
@Transactional
    public Attraction changeById(Long id, String name) {
Attraction attraction = attractionRepository.findById(id).orElseThrow(()-> new FindException("cant find"));
attraction.setName(name);
    return attraction;
    }

    public String deleteById(Long id) {
    Attraction attraction = attractionRepository.findById(id).orElseThrow(()-> new FindException("cant find"));
    attractionRepository.deleteById(id);
    return attraction.getName();
    }
@Transactional
    public Optional<Attraction> save(Attraction attraction) {
        attractionRepository.save(attraction);
        return Optional.of(attraction);
    }
}
