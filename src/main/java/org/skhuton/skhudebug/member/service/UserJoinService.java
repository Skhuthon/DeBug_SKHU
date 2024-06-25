package org.skhuton.skhudebug.member.service;


import org.skhuton.skhudebug.member.domain.Role;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.dto.JoinRequestDto;
import org.skhuton.skhudebug.member.execption.InvalidUserException;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserJoinService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserJoinService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Transactional
    public void join(JoinRequestDto joinRequestDto) {
        // 비밀번호를 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDto.getPassword());
        validateDuplicateLoginId(joinRequestDto.getLoginId());
        User user = User.builder()
                .loginId(joinRequestDto.getLoginId())
                .password(encodedPassword)
                .nickname(joinRequestDto.getNickname())
                .role(Role.ROLE_USER)
                .build();
        // 회원 정보 저장
        userRepository.save(user);
    }

    private void validateDuplicateLoginId(String loginId) {
        if (userRepository.existsByLoginId(loginId)) {
            throw new InvalidUserException("This ID is already taken.");
        }
    }


}