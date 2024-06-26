package org.skhuton.skhudebug.location.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.location.dto.LocationSaveReqDto;
import org.skhuton.skhudebug.location.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional
    public void save(LocationSaveReqDto locationSaveReqDto) {

    }
}
