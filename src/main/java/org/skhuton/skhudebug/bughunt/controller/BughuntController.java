package org.skhuton.skhudebug.bughunt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
@Tag(name = "Hunting Request API", description = "현재 위치 업데이트 및 주변 사용자 검색")
public class BughuntController {
    private final BughuntService bughuntService;

    @Operation(summary = "현재 위치 업데이트", description = "사용자 위치 정보 업데이트")
    @PostMapping
    public ResponseEntity<?> saveBughunt(@RequestBody BughuntSaveReqDto bughuntSaveReqDto) {
        bughuntService.save(bughuntSaveReqDto);
        return new ResponseEntity<>(SuccessCode.BUGHUNT_CREATE_SUCCESS, HttpStatus.CREATED);
    }

}
