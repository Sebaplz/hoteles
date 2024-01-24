package com.reserva.hoteles.controllers;

import com.reserva.hoteles.Dto.AdvertisementRequest;
import com.reserva.hoteles.Dto.AdvertisementResponse;
import com.reserva.hoteles.exceptions.SaveErrorException;
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

    @GetMapping("/my/advertisements")
    public Page<AdvertisementResponse> getAllAdvertisementByEmail(@RequestParam String email, Pageable pageable) {
        return advertisementService.getAllAdvertisementResponseByUserEmail(email, pageable);
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

    @PostMapping("/create/advertisement")
    public ResponseEntity<AdvertisementResponse> createAdvertisement(@RequestBody AdvertisementRequest request) {
        try{
            AdvertisementResponse response = advertisementService.createAdvertisement(request);
            return ResponseEntity.ok(response);
        } catch (SaveErrorException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AdvertisementResponse.builder().error(e.getMessage()).build());
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<AdvertisementResponse> updateAdvertisement(@PathVariable Long id, @RequestBody AdvertisementRequest request) {
        try{
            AdvertisementResponse updated = advertisementService.updateAdvertisement(id, request);
            return ResponseEntity.ok(updated);
        } catch (SaveErrorException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AdvertisementResponse.builder().error(e.getMessage()).build());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAdvertisement(@PathVariable("id") Long id) {
        try{
            AdvertisementResponse delete = advertisementService.deleteAdvertisement(id);
            return ResponseEntity.ok(delete);
        } catch (SaveErrorException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AdvertisementResponse.builder().error(e.getMessage()).build());
        }
    }
}
