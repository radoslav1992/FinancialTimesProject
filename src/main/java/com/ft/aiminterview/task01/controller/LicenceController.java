package com.ft.aiminterview.task01.controller;

import com.ft.aiminterview.task01.dao.LicenseRepository;
import com.ft.aiminterview.task01.dao.SeatRepository;
import com.ft.aiminterview.task01.domain.Licence;
import com.ft.aiminterview.task01.domain.Seat;
import com.ft.aiminterview.task01.dtos.LicenseRequestDto;
import com.ft.aiminterview.task01.dtos.LicenseResponseDto;
import com.ft.aiminterview.task01.service.LicenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/licences")
@RequiredArgsConstructor
@Slf4j
public class LicenceController {

    private final LicenseService licenseService;
    private final LicenseRepository licenseRepository;
    private final SeatRepository seatRepository;

    //TODO add http endpoint for creation of licence
    @PostMapping
    public ResponseEntity<LicenseResponseDto> createLicense(@RequestBody LicenseRequestDto licenseRequest) {
        LicenseResponseDto license = licenseService.create(licenseRequest);
        return ResponseEntity.ok()
                             .body(license);
    }
    //TODO add http endpoint for amending LicenseStatus
    // do not implement DELETE endpoint
    @PutMapping


    @GetMapping
    public ResponseEntity<List<LicenseResponseDto>> listAllLicenses() {
        final List<LicenseResponseDto> licences = licenseService.getAll();
        return ResponseEntity.ok()
                             .body(licences);
    }

    //TODO return the appropriate HTTP status code if either the seat is already allocated for a given user id
    // or seat limit has been exceeded or license status is NOT Active

    //TODO why HTTP 404 'not found' is not returned if licenceId doesn't exists, fix the bug

    //TODO implement validation for `joinedDate` >= Now() and  `seatExpiryDate` >= `joinedDate`,
    // return HTTP 422 'Unprocessable Entity' in validation can't pass
    @PostMapping("/allocate-seat/{licenceId}")
    public ResponseEntity<?> allocateSeat(
            @PathVariable("licenceId") ObjectId licenceId,
            @RequestBody Seat seat) {
        final Optional<Licence> licence = licenseRepository.findById(licenceId);
        licence.ifPresentOrElse(l -> {
            seat.setAccessLicenceId(licenceId);
            final Seat newSeat = seatRepository.save(seat);
            l.getSeats().add(newSeat);
            licenseRepository.save(l);
            log.info("Successfully allocated seat={} for licence={}", newSeat.getId(), licenceId);

        }, (() -> ResponseEntity.notFound().build()));

        return ResponseEntity.ok().build();
    }

    //TODO implement deallocate-seat endpoint

}
