package com.example.attraction.service;

import com.example.attraction.repository.ServiceRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.util.Optional;

@Service
public class ServiceService {
    private
    private ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Optional<com.example.attraction.entity.Service> findById(Long id) {
        return serviceRepository.findById(id);
    }
public String deleteById(Long id){
       String name = "cant find service";
        com.example.attraction.entity.Service service =  serviceRepository.findById(id).orElseThrow(()-> new FindException("cant find id from service"));
        if (service!=null){
          name = service.getDescription();
        }
        serviceRepository.deleteById(id);
return name;
    }
    @Transactional
public Optional<com.example.attraction.entity.Service> save(Integer number, String description, String type, Long id){
    com.example.attraction.entity.Service service = new com.example.attraction.entity.Service(number,description,type,id);
serviceRepository.save(service);
return Optional.of(service);
    }
}
