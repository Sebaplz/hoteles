package com.reserva.hoteles.controllers;

import com.reserva.hoteles.Dto.AdvertisementRequest;
import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.entity.Advertisement;
import com.reserva.hoteles.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advertisements")
@CrossOrigin(origins = "${CORS_ORIGIN}")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public Page<AdvertisementResponse> getAllAdvertisement(Pageable pageable) {
        return advertisementService.getAllAdvertisements(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementResponse> getAdvertisementById(@PathVariable Long id) {
        AdvertisementResponse advertisementResponse = advertisementService.getAdvertisementResponseById(id);
        if (advertisementResponse != null) {
            return new ResponseEntity<>(advertisementResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody AdvertisementRequest request) {
        Advertisement createdAdvertisement = advertisementService.createAdvertisement(request);

        if (createdAdvertisement != null) {
            return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable Long id, @RequestBody AdvertisementRequest request) {
//        Advertisement updated = advertisementService.updateAdvertisement(id, request);
//        if (updated != null) {
//            return new ResponseEntity<>(updated, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
