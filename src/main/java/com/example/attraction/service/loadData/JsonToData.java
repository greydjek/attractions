package com.example.attraction.service.loadData;

import com.example.attraction.entity.Address;
import com.example.attraction.repository.AddressRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
@Data
@AllArgsConstructor
public class JsonToData {
    private static Logger logger= LoggerFactory.getLogger(JsonToData.class);
    private AddressRepository addressRepository;
    public void jsonTestData() {
        URL url = this.getClass().getClassLoader().getResource("MOCK_DATA.json");
        File jsonFile = null;
        jsonFile = new File(url.getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        try {// ВМЕСТО address любой Object BD
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
