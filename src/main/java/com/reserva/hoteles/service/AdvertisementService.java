package com.reserva.hoteles.service;

import com.reserva.hoteles.Dto.AdvertisementRequest;
import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.entity.Advertisement;
import com.reserva.hoteles.entity.User;
import com.reserva.hoteles.repository.AdvertisementRepository;
import com.reserva.hoteles.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private UserRepository userRepository;

    public Page<AdvertisementResponse> getAllAdvertisements(Pageable pageable) {
        return advertisementRepository.findAllAdvertisement(pageable);
    }

    public Advertisement getAdvertisementById(Long id) {
        return advertisementRepository.findById(id).orElse(null);
    }

    public Advertisement createAdvertisement(AdvertisementRequest request) {
        Advertisement newAdvertisement = new Advertisement();
        newAdvertisement.setTitle(request.getTitle());
        newAdvertisement.setDescription(request.getDescription());
        newAdvertisement.setAddress(request.getAddress());
        newAdvertisement.setPricePerNight(request.getPricePerNight());
        newAdvertisement.setImageUrl(request.getImageUrl());

        return advertisementRepository.save(newAdvertisement);
    }

    public Advertisement updateAdvertisement(Long id, AdvertisementRequest updatedAdvertisement) {
        Advertisement existingAdvertisement = getAdvertisementById(id);

        if (existingAdvertisement != null) {
            User owner = userRepository.findUserByEmail(updatedAdvertisement.getEmail())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con email: " + updatedAdvertisement.getEmail()));

            existingAdvertisement.setTitle(updatedAdvertisement.getTitle());
            existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
            existingAdvertisement.setAddress(updatedAdvertisement.getAddress());
            existingAdvertisement.setPricePerNight(updatedAdvertisement.getPricePerNight());
            existingAdvertisement.setImageUrl(updatedAdvertisement.getImageUrl());
            existingAdvertisement.setOwner(owner);

            return advertisementRepository.save(existingAdvertisement);
        }

        return null;
    }

    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }

}

