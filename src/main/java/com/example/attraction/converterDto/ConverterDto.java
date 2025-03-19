package com.example.attraction.converterDto;

import com.example.attraction.dto.AddressDto;
import com.example.attraction.dto.ServiceDto;
import com.example.attraction.entity.Address;
import com.example.attraction.entity.Service;
import org.springframework.stereotype.Component;

@Component
public class ConverterDto {
    public AddressDto converterAddressToDto(Address address) {
            return new AddressDto(address.getId(), address.getBuilding(), address.getAddress());
     }

    public Address converterAddressDtoToAddress(AddressDto addressDto) {
        return new Address(addressDto.getId(), addressDto.getBuilding(), addressDto.getAddress());
    }

    public Service converterServiceToDto(Service serviceDto) {
        return new Service(serviceDto.getId(), serviceDto.getDescription(), serviceDto.getType());
    }

    public ServiceDto converterServiceDToService(Service service) {
        return new ServiceDto(service.getId(), service.getDescription(),service.getType());
    }



}
