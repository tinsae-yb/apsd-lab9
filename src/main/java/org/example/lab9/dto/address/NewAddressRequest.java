package org.example.lab9.dto.address;

import lombok.Data;

@Data
public class NewAddressRequest {
    private String addressOne;
    private String city;
    private String state;
}
