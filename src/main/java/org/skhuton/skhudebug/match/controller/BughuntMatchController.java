package org.skhuton.skhudebug.match.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.common.dto.BaseResponse;
import org.skhuton.skhudebug.exception.SuccessCode;
import org.skhuton.skhudebug.match.dto.MatchReqDto;
import org.skhuton.skhudebug.match.service.MatchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Bughunt Match API", description = "헌트 요청의 수락과 업무의 완료를 담당하는 API")
public class BughuntMatchController {
    private final MatchService matchService;

    @Operation(summary = "헌트 요청 수락", description = "헌트 요청을 수락하는 API")
    @Parameters({
            @Parameter(name = "senderId", description = "호출하는 사용자 아이디", required = true),
            @Parameter(name = "requestId", description = "헌트 요청 건 고유의 아이디", required = true),
            @Parameter(name = "receiveId", description = "호출받는 사용자의 아이디", required = true)
    })
    @PostMapping("/bughunt-matching")
    public BaseResponse<String> bughuntMatching(@RequestBody MatchReqDto matchReqDto) {
        matchService.acceptByHunter(matchReqDto);
        return BaseResponse.success(SuccessCode.BUGHUNT_REQUEST_ACCEPT);
    }
}
