package com.example.attraction.service;

import com.example.attraction.entity.Address;
import com.example.attraction.repository.AddressRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.module.FindException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Data
public class AddressService {
private final static Logger logger = LoggerFactory.getLogger(AddressService.class.getClass());
  private final AddressRepository addressRepository;
@Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

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
        Address address = new Address();
        address.setAddress(newAddress);
        address.setRegion(newRegion);
        addressRepository.save(address);
        return address;
    }
    public void jsonTestData() {
        URL url = this.getClass().getClassLoader().getResource("MOCK_DATA.json");
        File jsonFile = null;
        jsonFile = new File(url.getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Address> addressList =objectMapper.readValue(jsonFile, new TypeReference<List<Address>>() {
                @Override
                public int compareTo(TypeReference<List<Address>> o) {
                    return super.compareTo(o);
                }
            }
            );
            addressRepository.saveAll(addressList);
logger.info("all data address save");
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
