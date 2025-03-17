package com.example.attraction.service;

import com.example.attraction.entity.Address;
import com.example.attraction.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class AddressService {
    final AddressRepository addressRepository;

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public Optional<String> deleteById(Long id) {
        String s = addressRepository.findById(id).get().getAddress();
        addressRepository.deleteById(id);
        return Optional.ofNullable(s);
    }

    @Transactional
    public Address changeById(Long id, String newAddress) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new FindException("cant find address by Id" + id));
        address.setAddress(newAddress);
        return address;
    }

    public Address saveNew(String newRegion, String newAddress) {
    Address address= new Address();
    address.setAddress(newAddress);
    address.setRegion(newRegion);
        addressRepository.save(address);
        return address;
    }
}
