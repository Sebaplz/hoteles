package com.reserva.hoteles.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementResponse {
    private Long id;
    private String status;
    private String addressExtended;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private String firstName;
    private String lastName;
    private int numOfPersons;
    private int numOfBedrooms;
    private int numOfBathrooms;
    private String error;
    private String message;

    public AdvertisementResponse(Long id, String status, String addressExtended, String description, String address, BigDecimal pricePerNight, String imageUrl, String firstName, String lastName, int numOfPersons, int numOfBedrooms, int numOfBathrooms) {
        this.id = id;
        this.status = status;
        this.addressExtended = addressExtended;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public AdvertisementResponse(Long id, String status, String addressExtended, String description, String address, BigDecimal pricePerNight, String imageUrl) {
        this.id = id;
        this.status = status;
        this.addressExtended = addressExtended;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
    }
}
