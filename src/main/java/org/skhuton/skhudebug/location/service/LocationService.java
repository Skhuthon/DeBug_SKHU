package org.skhuton.skhudebug.location.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.location.domain.Location;
import org.skhuton.skhudebug.location.dto.LocationSaveReqDto;
import org.skhuton.skhudebug.location.repository.LocationRepository;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(LocationSaveReqDto locationSaveReqDto) {
        User user = userRepository.findByLoginId(locationSaveReqDto.loginId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Location location = Location.builder()
                .user(user)
                .latitude(locationSaveReqDto.latitude())
                .longitude(locationSaveReqDto.longitude())
                .build();

        locationRepository.save(location);
    }
}
