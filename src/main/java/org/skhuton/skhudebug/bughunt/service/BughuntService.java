package org.skhuton.skhudebug.bughunt.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.skhuton.skhudebug.bughunt.dto.BughuntSaveReqDto;
import org.skhuton.skhudebug.bughunt.repository.BughuntRepository;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BughuntService {
    private final BughuntRepository bughuntRepository;
    private final UserRepository userRepository;

    @Transactional
    public Bughunt save(BughuntSaveReqDto bughuntSaveReqDto) {
        User user = userRepository.findByLoginId(bughuntSaveReqDto.loginId())
                .orElseThrow(() -> new IllegalArgumentException("유저 정보를 찾을 수 없습니다"));

        Bughunt bughunt = Bughunt.builder()
                .user(user)
                .latitude(bughuntSaveReqDto.latitude())
                .longitude(bughuntSaveReqDto.longitude())
                .bugNum(bughuntSaveReqDto.bugNum())
                .bugSize(bughuntSaveReqDto.bugSize())
                .bugType(bughuntSaveReqDto.bugType())
                .radius(bughuntSaveReqDto.radius())
                .build();

        bughunt.setCreatedAt(LocalDateTime.now());
        return bughuntRepository.save(bughunt);
    }
}
