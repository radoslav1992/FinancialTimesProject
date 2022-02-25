package com.ft.aiminterview.task01.mapper;

import com.ft.aiminterview.task01.domain.Licence;
import com.ft.aiminterview.task01.dtos.LicenseRequestDto;
import com.ft.aiminterview.task01.dtos.LicenseResponseDto;

public class LicenseMapper {
    public static Licence licenseRequestDtoToLicence(LicenseRequestDto licenseRequest) {
        Licence license = new Licence();

        license.setProducts(licenseRequest.getProducts());
        license.setRevocationDateTime(licenseRequest.getRevocationDateTime());
        license.setStatus(licenseRequest.getStatus());
        license.setSeatLimit(licenseRequest.getSeatLimit());
        license.setIpAccessEnabled(licenseRequest.isIpAccessEnabled());
        license.setIpAccessAddresses(licenseRequest.getIpAccessAddresses());

        return license;
    }

    public static LicenseResponseDto licenceToLicenseResponseDto(Licence license) {
        LicenseResponseDto licenseResponse = new LicenseResponseDto();

        licenseResponse.setAccessLicenceId(license.getAccessLicenceId());
        licenseResponse.setCreationDateTime(license.getCreationDateTime());
        licenseResponse.setProducts(license.getProducts());
        licenseResponse.setRevocationDateTime(license.getRevocationDateTime());
        licenseResponse.setStatus(license.getStatus());
        licenseResponse.setSeatLimit(license.getSeatLimit());
        licenseResponse.setIpAccessEnabled(license.isIpAccessEnabled());
        licenseResponse.setIpAccessAddresses(license.getIpAccessAddresses());
        licenseResponse.setLastUpdatedDateTime(license.getLastUpdatedDateTime());

        return licenseResponse;
    }
}
