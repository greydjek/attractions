package com.example.attraction.controllers;

import com.example.attraction.entity.Address;
import com.example.attraction.service.AddressService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Data
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/address/{id}")
    public Optional<Address> findAddress(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @DeleteMapping("/address_del/{id}")
    public Optional<String> deleteAddress(@PathVariable Long id) {
        return addressService.deleteById(id);
    }

    @GetMapping("/address_change/")
    public Address changeAddress(@RequestParam Long id, @RequestParam String newAddress) {
        return addressService.changeById(id, newAddress);
    }
    @GetMapping("/address_save_new/")
    public Address changeAddress(@RequestParam String newRegion, @RequestParam String newAddress) {
        return addressService.saveNew(newRegion, newAddress);
    }


}
