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

import java.util.Optional;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private UserRepository userRepository;

    public Page<AdvertisementResponse> getAllAdvertisements(Pageable pageable) {
        return advertisementRepository.findAllAdvertisement(pageable);
    }

    public AdvertisementResponse getAdvertisementResponseById(Long id) {
        Optional<Advertisement> optionalAdvertisement = advertisementRepository.findById(id);

        if (optionalAdvertisement.isPresent()) {
            Advertisement advertisement = optionalAdvertisement.get();
            return convertToAdvertisementResponse(advertisement);
        }

        return null;
    }

    private AdvertisementResponse convertToAdvertisementResponse(Advertisement advertisement) {
        return AdvertisementResponse.builder()
                .id(advertisement.getId())
                .status(advertisement.getStatus())
                .addressExtended(advertisement.getAddressExtended())
                .description(advertisement.getDescription())
                .address(advertisement.getAddress())
                .pricePerNight(advertisement.getPricePerNight())
                .imageUrl(advertisement.getImageUrl())
                .username(advertisement.getOwner().getUserName())
                .numOfPersons(advertisement.getNumOfPersons())
                .numOfBedrooms(advertisement.getNumOfBedrooms())
                .numOfBathrooms(advertisement.getNumOfBathrooms())
                .build();
    }

    public Advertisement createAdvertisement(AdvertisementRequest request) {
        Advertisement newAdvertisement = new Advertisement();
        newAdvertisement.setStatus(request.getStatus());
        newAdvertisement.setDescription(request.getDescription());
        newAdvertisement.setAddress(request.getAddress());
        newAdvertisement.setAddressExtended(request.getAddressExtended());
        newAdvertisement.setPricePerNight(request.getPricePerNight());
        newAdvertisement.setImageUrl(request.getImageUrl());
        newAdvertisement.setNumOfPersons(request.getNumOfPersons());
        newAdvertisement.setNumOfBedrooms(request.getNumOfBedrooms());
        newAdvertisement.setNumOfBathrooms(request.getNumOfBathrooms());

        return advertisementRepository.save(newAdvertisement);
    }

//    public Advertisement updateAdvertisement(Long id, AdvertisementRequest updatedAdvertisement) {
//        Advertisement existingAdvertisement = getAdvertisementById(id);
//
//        if (existingAdvertisement != null) {
//            User owner = userRepository.findUserByEmail(updatedAdvertisement.getEmail())
//                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con email: " + updatedAdvertisement.getEmail()));
//
//            existingAdvertisement.setStatus(updatedAdvertisement.getStatus());
//            existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
//            existingAdvertisement.setAddress(updatedAdvertisement.getAddress());
//            existingAdvertisement.setAddressExtended(updatedAdvertisement.getAddressExtended());
//            existingAdvertisement.setPricePerNight(updatedAdvertisement.getPricePerNight());
//            existingAdvertisement.setImageUrl(updatedAdvertisement.getImageUrl());
//            existingAdvertisement.setNumOfPersons(updatedAdvertisement.getNumOfPersons());
//            existingAdvertisement.setNumOfBedrooms(updatedAdvertisement.getNumOfBedrooms());
//            existingAdvertisement.setNumOfBathrooms(updatedAdvertisement.getNumOfBathrooms());
//            existingAdvertisement.setOwner(owner);
//
//            return advertisementRepository.save(existingAdvertisement);
//        }
//
//        return null;
//    }

    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }

}

