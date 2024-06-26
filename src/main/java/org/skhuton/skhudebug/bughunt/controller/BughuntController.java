package org.skhuton.skhudebug.bughunt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.skhuton.skhudebug.common.dto.BaseResponse;
import org.skhuton.skhudebug.exception.SuccessCode;
import org.skhuton.skhudebug.bughunt.dto.BughuntSaveReqDto;
import org.skhuton.skhudebug.bughunt.service.BughuntService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bughunt")
@Tag(name = "Bughunt API", description = "버그 헌트 요청 및 추적")
public class BughuntController {
    private final BughuntService bughuntService;

    @Operation(summary = "버그 헌트 요청 생성", description = "사용자 위치 및 벌레 세부정보가 포함된 버그헌터 찾기 요청 생성")
    @PostMapping
    public BaseResponse<String> createBughunt(@RequestBody BughuntSaveReqDto bughuntSaveReqDto) {
        bughuntService.save(bughuntSaveReqDto);
        return BaseResponse.success(SuccessCode.BUGHUNT_CREATE_SUCCESS);
    }
}
