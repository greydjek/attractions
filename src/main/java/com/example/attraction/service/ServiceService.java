package com.example.attraction.service;

import com.example.attraction.converterDto.ConverterDto;
import com.example.attraction.dto.ServiceDto;
import com.example.attraction.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.util.Optional;

@Service
public class ServiceService {
    private ConverterDto converterDto;
    private ServiceRepository serviceRepository;
@Autowired
    public ServiceService(ConverterDto converterDto, ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    this.converterDto= converterDto;
}

    public Optional<ServiceDto> findById(Long id) {
 Object s =  serviceRepository.findById(id).map(converterDto::converterServiceToDto).orElseThrow(()->new FindException("cant find by id" +id));
    return (Optional<ServiceDto>) s;
}

    public String deleteById(Long id) {
        String name = "cant find service";
        com.example.attraction.entity.Service service = serviceRepository.findById(id).orElseThrow(() -> new FindException("cant find id from service"));
        if (service != null) {
            name = service.getDescription();
        }
        serviceRepository.deleteById(id);
        return name;
    }

    @Transactional
    public Optional<com.example.attraction.entity.Service> save(com.example.attraction.entity.Service service) {
        serviceRepository.save(service);
        return Optional.of(service);
    }
}
