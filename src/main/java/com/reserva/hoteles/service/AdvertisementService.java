package com.reserva.hoteles.service;

import com.reserva.hoteles.Dto.AdvertisementRequest;
import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.entity.Advertisement;
import com.reserva.hoteles.entity.User;
import com.reserva.hoteles.repository.AdvertisementRepository;
import com.reserva.hoteles.repository.UserRepository;
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
                .firstName(advertisement.getOwner().getFirstName())
                .lastName(advertisement.getOwner().getLastName())
                .numOfPersons(advertisement.getNumOfPersons())
                .numOfBedrooms(advertisement.getNumOfBedrooms())
                .numOfBathrooms(advertisement.getNumOfBathrooms())
                .build();
    }

    public AdvertisementResponse createAdvertisement(AdvertisementRequest request) {
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

        Optional<User> optionalUser = userRepository.findUserByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            newAdvertisement.setOwner(optionalUser.get());

            try {
                Advertisement savedAdvertisement = advertisementRepository.save(newAdvertisement);
                return AdvertisementResponse.builder().id(savedAdvertisement.getId()).message("Guardado con éxito!").build();
            } catch (Exception e) {
                return AdvertisementResponse.builder().error("Error al guardar! La dirección ya esta en uso!").build();
            }
        }
        return AdvertisementResponse.builder().error("No se ha podido agregar, porque el usuario no era valido!").build();
    }


    public AdvertisementResponse updateAdvertisement(Long id, AdvertisementRequest updatedAdvertisement) {
        Optional<Advertisement> optionalExistingAdvertisement = advertisementRepository.findById(id);
        Optional<User> optionalUser = userRepository.findUserByEmail(updatedAdvertisement.getEmail());

        if (optionalExistingAdvertisement.isPresent() && optionalUser.isPresent()) {
            Advertisement existingAdvertisement = optionalExistingAdvertisement.get();
            User owner = optionalUser.get();

            existingAdvertisement.setStatus(updatedAdvertisement.getStatus());
            existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
            existingAdvertisement.setAddress(updatedAdvertisement.getAddress());
            existingAdvertisement.setAddressExtended(updatedAdvertisement.getAddressExtended());
            existingAdvertisement.setPricePerNight(updatedAdvertisement.getPricePerNight());
            existingAdvertisement.setImageUrl(updatedAdvertisement.getImageUrl());
            existingAdvertisement.setNumOfPersons(updatedAdvertisement.getNumOfPersons());
            existingAdvertisement.setNumOfBedrooms(updatedAdvertisement.getNumOfBedrooms());
            existingAdvertisement.setNumOfBathrooms(updatedAdvertisement.getNumOfBathrooms());
            existingAdvertisement.setOwner(owner);

            advertisementRepository.save(existingAdvertisement);
            return AdvertisementResponse.builder().message("Alojamiento actualizado!").build();
        }

        return AdvertisementResponse.builder().error("Alojamiento o usuario no encontrado!").build();
    }



    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }

}

