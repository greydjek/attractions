package com.example.attraction.controllers;

import com.example.attraction.dto.AddressDto;
import com.example.attraction.entity.Address;
import com.example.attraction.entity.Attraction;
import com.example.attraction.service.AddressService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
@Data
@NoArgsConstructor
public class AddressController {
    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Optional<AddressDto> findAddress(@PathVariable Long id) {
        logger.info("Get mapping " + addressService.findById(id).toString());
        return addressService.findById(id);
    }
    @GetMapping("/all")
    public List<AddressDto> findAddress() {
        logger.info("Get mapping " + addressService.findAll().toString());
        return addressService.findAll();
    }

//    @GetMapping("at_by_city/")
//    public Optional<Attraction> findByCity(@RequestParam String city) {
////        logger.info("Get mapping " + addressService.findById(id).toString());
////        return addressService.findAttractionByCity(city);
//    }

    @DeleteMapping("/del/{id}")
    public Optional<String> deleteAddress(@PathVariable Long id) {
        logger.info("Delete mapping" + id);
        return addressService.deleteById(id);
    }

    @GetMapping("/change/")
    public Address changeAddress(@RequestParam Long id, @RequestParam String newAddress) {
        logger.info("Get mapping" + id + newAddress);
        return addressService.changeById(id, newAddress);
    }

    @PostMapping("/save_new")
    public Address changeAddress(@RequestBody Address address) {
        logger.info("Post mapping save " + address.toString());
        return addressService.saveNew(address);
    }

    @GetMapping("/testData")
    public void test() {
        addressService.jsonTestData();
    }
}
