package com.reserva.hoteles.Dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AdvertisementResponse {
    private Long id;
    private String status;
    private String addressExtended;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private String username;
    private int numOfPersons;
    private int numOfBedrooms;
    private int numOfBathrooms;

    public AdvertisementResponse(Long id, String status, String addressExtended, String description, String address, BigDecimal pricePerNight, String imageUrl, String username, int numOfPersons, int numOfBedrooms, int numOfBathrooms) {
        this.id = id;
        this.status = status;
        this.addressExtended = addressExtended;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
        this.username = username;
        this.numOfPersons = numOfPersons;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfBathrooms = numOfBathrooms;
    }

    public AdvertisementResponse(Long id, String status, String description, String address, BigDecimal pricePerNight, String imageUrl) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
    }
}
