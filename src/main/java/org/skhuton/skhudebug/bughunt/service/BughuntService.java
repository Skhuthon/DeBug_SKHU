package org.skhuton.skhudebug.bughunt.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.skhuton.skhudebug.bughunt.dto.BughuntSaveReqDto;
import org.skhuton.skhudebug.bughunt.repository.BughuntRepository;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BughuntService {
    private final BughuntRepository bughuntRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(BughuntSaveReqDto bughuntSaveReqDto) {
        User user = userRepository.findByLoginId(bughuntSaveReqDto.loginId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Bughunt bughunt = Bughunt.builder()
                .user(user)
                .latitude(bughuntSaveReqDto.latitude())
                .longitude(bughuntSaveReqDto.longitude())
                .build();

        bughuntRepository.save(bughunt);
    }
}
