package com.example.attraction.service;

import com.example.attraction.dto.AddressDto;
import com.example.attraction.entity.Address;
import com.example.attraction.entity.Service;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.lang.module.FindException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    @Test
    void findById() {
        AddressDto addressDto= new AddressDto(1L,"aaaa","dddd");
        AddressService mockAddressService = Mockito.mock(AddressService.class);
        Mockito.when(mockAddressService.findById(1L)).thenReturn(Optional.of(addressDto));
    }

    @Test
    void deleteById() {
        Address address = new Address(1L,"aaaa","dddd");
        AddressService mockAddressService = Mockito.mock(AddressService.class);
        Mockito.when(mockAddressService.deleteById(address.getId())).thenReturn(Optional.ofNullable(address.getAddress()));

    }

    @Test
    void changeById() {
        AddressService mockAddressService = Mockito.mock(AddressService.class);
        Mockito.when(mockAddressService.changeById(-1L,"gsvdhc")).thenThrow(new FindException());
    }

    @Test
    void saveNew() {
        Address address1 = new Address(1L,"aaaa","dddd");
        AddressService mockAddressService = Mockito.mock(AddressService.class);
        Mockito.when(mockAddressService.saveNew(address1)).thenReturn(address1);
    }

    @Test
    void getConverterDto() {
    }
}