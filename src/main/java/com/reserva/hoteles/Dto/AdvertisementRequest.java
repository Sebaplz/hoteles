package com.reserva.hoteles.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementRequest {
    private String title;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private String email;

}
