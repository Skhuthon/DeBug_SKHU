package org.skhuton.skhudebug.location.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.exception.SuccessCode;
import org.skhuton.skhudebug.location.dto.LocationSaveReqDto;
import org.skhuton.skhudebug.location.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
@Tag(name = "Location Tracking API", description = "현재 위치 업데이트 및 주변 사용자 검색")
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "현재 위치 업데이트", description = "사용자 위치 정보 업데이트")
    @PostMapping
    public ResponseEntity<?> saveLocation(@RequestBody LocationSaveReqDto locationSaveReqDto) {
        locationService.save(locationSaveReqDto);
        return new ResponseEntity<>(SuccessCode.LOCATION_CREATE_SUCCESS, HttpStatus.CREATED);
    }

}
