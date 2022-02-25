package com.ft.aiminterview.task01.service;

import com.ft.aiminterview.task01.dao.LicenseRepository;
import com.ft.aiminterview.task01.domain.Licence;
import com.ft.aiminterview.task01.dtos.LicenseRequestDto;
import com.ft.aiminterview.task01.dtos.LicenseResponseDto;
import com.ft.aiminterview.task01.mapper.LicenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseResponseDto create(LicenseRequestDto licenseRequest) {
        Licence license = LicenseMapper.licenseRequestDtoToLicence(licenseRequest);

        return LicenseMapper.licenceToLicenseResponseDto(licenseRepository.save(license));
    }

    public List<LicenseResponseDto> getAll() {
        List<LicenseResponseDto> licenses =
            licenseRepository.findAll().stream().map(LicenseMapper::licenceToLicenseResponseDto).collect(Collectors.toList());

        return licenses;
    }
}
