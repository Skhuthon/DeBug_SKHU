package org.skhuton.skhudebug.member.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.skhuton.skhudebug.member.dto.JoinRequestDto;
import org.skhuton.skhudebug.member.service.UserJoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "JOIN", description = "회원가입 API")
public class UserJoinController {

    private final UserJoinService userJoinService;

    public UserJoinController(UserJoinService userJoinService) {
        this.userJoinService = userJoinService;
    }

    @ApiResponse(responseCode = "200", description = "Membership registration completed!", content = @Content(mediaType = "application/json"))
    @Parameters({
            @Parameter(name = "loginId", description = "회원가입을 위한 고유의 아이디", required = true),
            @Parameter(name = "password", description = "회원 개인의 고유한 비밀번호", required = true),
            @Parameter(name = "nickname", description = "회원 개인의 고유한 닉네임", required = true)
    })
    @PostMapping("/user/join")
    public ResponseEntity<String> userJoin(@RequestBody JoinRequestDto joinRequestDto) {
        userJoinService.join(joinRequestDto);
        return new ResponseEntity<>("Membership registration completed!", HttpStatus.OK);
    }

}
