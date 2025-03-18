package com.example.attraction.controllers;

import com.example.attraction.entity.Address;
import com.example.attraction.service.AddressService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
@Data
public class AddressController {
    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);
    private AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Optional<Address> findAddress(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @DeleteMapping("/del/{id}")
    public Optional<String> deleteAddress(@PathVariable Long id) {
        return addressService.deleteById(id);
    }

    @GetMapping("/change/")
    public Address changeAddress(@RequestParam Long id, @RequestParam String newAddress) {
        return addressService.changeById(id, newAddress);
    }
    @GetMapping("/save_new/")
    public Address changeAddress(@RequestParam String newRegion, @RequestParam String newAddress) {
        logger.info("принятые параметры %s newRegion и %s newAddress" + newRegion + newAddress);
        return addressService.saveNew(newRegion, newAddress);
    }
@GetMapping("/testData")
    public void test(){
        addressService.jsonTestData();
}
}
