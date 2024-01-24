package com.reserva.hoteles.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String description;
    private String address;
    @Column(unique = true)
    private String addressExtended;
    private BigDecimal pricePerNight;
    private String imageUrl;
    private int numOfPersons;
    private int numOfBedrooms;
    private int numOfBathrooms;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
