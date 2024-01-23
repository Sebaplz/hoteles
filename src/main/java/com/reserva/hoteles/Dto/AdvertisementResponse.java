package com.reserva.hoteles.Dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AdvertisementResponse {
    private Long id;
    private String title;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private String username;

    public AdvertisementResponse(Long id, String title, String description, String address, BigDecimal pricePerNight, String imageUrl, String username) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
        this.username = username;
    }

    public AdvertisementResponse(Long id, String title, String description, String address, BigDecimal pricePerNight, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.imageUrl = imageUrl;
    }
}
