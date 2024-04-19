package org.example.lab9.dto.address;

import lombok.Data;
import org.example.lab9.entity.Address;

@Data
public class AddressResponse {
    private Long id;
    private String addressOne;
    private String city;
    private String state;

    public static AddressResponse fromAddress(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.id = address.getId();
        addressResponse.addressOne = address.getAddressOne();
        addressResponse.city = address.getCity();
        addressResponse.state = address.getState();
        return addressResponse;

    }
}
