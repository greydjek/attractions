package com.example.attraction.service;

import com.example.attraction.converterDto.ConverterDto;
import com.example.attraction.dto.AddressDto;
import com.example.attraction.entity.Address;
import com.example.attraction.repository.AddressRepository;
import com.example.attraction.service.loadData.JsonToData;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Data
public class AddressService {
private final static Logger logger = LoggerFactory.getLogger(AddressService.class.getClass());
private ConverterDto converterDto;
  private  AddressRepository addressRepository;
  private final JsonToData json;

    @Autowired
    public AddressService(AddressRepository addressRepository, ConverterDto converterDto, JsonToData json) {
        this.addressRepository = addressRepository;
this.converterDto = converterDto;
        this.json = json;
    }

    public Optional<AddressDto> findById(Long id) {
        return  addressRepository.findById(id).map(converterDto::converterAddressToDto);
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

    public Address saveNew(Address address) {
        addressRepository.save(address);
        return address;
    }

    public List<AddressDto> findAll() {
    return addressRepository.findAll().stream().map(converterDto::converterAddressToDto).collect(Collectors.toList());
    }

    public void jsonTestData() {
    json.jsonTestData();
    }

//    public Optional<Attraction> findAttractionByCity(String city) {
//addressRepository.findAllBy
//}
}
