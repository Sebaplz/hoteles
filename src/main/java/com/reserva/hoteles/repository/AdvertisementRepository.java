package com.reserva.hoteles.repository;

import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.entity.Advertisement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    @Query("SELECT new com.reserva.hoteles.Dto.AdvertisementResponse(a.id, a.title, a.description, a.address, a.pricePerNight, a.imageUrl) FROM Advertisement a")
    Page<AdvertisementResponse> findAllAdvertisement(Pageable pageable);


}
