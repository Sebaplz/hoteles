package com.reserva.hoteles.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementRequest {
    private String status;
    private String addressExtended;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private String email;
    private int numOfPersons;
    private int numOfBedrooms;
    private int numOfBathrooms;

}
