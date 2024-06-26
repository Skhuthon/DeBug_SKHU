package org.skhuton.skhudebug.rank.controller;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.domain.User;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.skhuton.skhudebug.rank.domain.HuntTime;
import org.skhuton.skhudebug.rank.dto.HuntTimeRanking;
import org.skhuton.skhudebug.rank.repository.HuntTimeRepository;
import org.skhuton.skhudebug.rank.service.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankingService rankingService;
    private final HuntTimeRepository huntTimeRepository;
    private final UserRepository userRepository;

    @GetMapping("/rank")
    public ResponseEntity<List<HuntTimeRanking>> getRanking() {
        return new ResponseEntity<>(rankingService.getRanking(), HttpStatus.OK);
    }

    @PostMapping("/rank/dummy")
    public ResponseEntity<Void> createDummyData(Authentication authentication) {
        User user = userRepository.findByLoginId(authentication.getName()).get();
        huntTimeRepository.save(HuntTime.builder().times(100).user(user).build());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
