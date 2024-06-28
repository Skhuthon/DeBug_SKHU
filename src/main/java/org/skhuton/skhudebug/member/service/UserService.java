package org.skhuton.skhudebug.member.service;



import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.domain.PrincipalDetail;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.execption.InvalidUserException;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
        return new PrincipalDetail(user);
    }

    //로그인 상태 확인 메서드
    //로그인 상태면 로그인한 유저아이디를 반환하고, 로그인 상태 확인 결과을 반환.

    public String loginConfirmUserID(HttpServletRequest request) throws InvalidUserException {
        Principal user = request.getUserPrincipal();
        if (user != null) {
            User loginUser = userRepository.findByLoginId(user.getName()).orElseThrow(() -> new InvalidUserException("로그인 상태가 아닙니다."));
            return loginUser.getLoginId();
        }
        throw new InvalidUserException("not login");
    }
}