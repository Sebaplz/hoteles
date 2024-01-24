package com.reserva.hoteles.repository;

import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.entity.Advertisement;
import com.reserva.hoteles.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    @Query("SELECT new com.reserva.hoteles.Dto.AdvertisementResponse(a.id, a.status, a.description, a.address, a.pricePerNight, a.imageUrl) FROM Advertisement a")
    Page<AdvertisementResponse> findAllAdvertisement(Pageable pageable);

    @Query("SELECT new com.reserva.hoteles.Dto.AdvertisementResponse(a.id, a.status, a.addressExtended, a.description, a.address, a.pricePerNight, a.imageUrl) FROM Advertisement a WHERE a.owner = :user")
    Page<AdvertisementResponse> findAllAdvertisementByOwner(@Param("user") User user, Pageable pageable);

}
