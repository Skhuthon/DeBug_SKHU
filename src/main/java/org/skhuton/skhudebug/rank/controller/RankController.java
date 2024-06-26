package org.skhuton.skhudebug.rank.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.common.dto.BaseResponse;
import org.skhuton.skhudebug.exception.SuccessCode;
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

    @Operation(summary = "랭킹 조회", description = "유저의 벌레잡기 횟수를 기반으로 매긴 순위")
    @GetMapping("/rank")
    public BaseResponse<List<HuntTimeRanking>> getRanking() {
        return BaseResponse.success(SuccessCode.RANKING_GET_SUCCESS, rankingService.getRanking());
    }

    @Operation(summary = "test 전용 랭킹 Dummy Data 생성", description = "테스트를 위한 더미 데이터")
    @PostMapping("/rank/dummy")
    public ResponseEntity<Void> createDummyData(Authentication authentication) {
        User user = userRepository.findByLoginId(authentication.getName()).get();
        huntTimeRepository.save(HuntTime.builder().times(100).user(user).build());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
