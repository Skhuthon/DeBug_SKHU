package org.skhuton.skhudebug.member.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.dto.response.UserInfo;
import org.skhuton.skhudebug.member.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "로그인 확인", description = "본 API는 유저의 로그인 상태를 확인하는 기능만 존재함.")
public class UserController {
    private final UserService userService;

    /*
    로그인 URL은 /user/login이며, POST 방식으로 로그인을 진행합니다.
    요청 데이터는 JSON 형식이 아니며, form-data 형식으로 전송합니다.
     */
    @Operation(summary = "로그인 확인", description = "해당 클라이언트의 로그인 확인")
    @GetMapping("/user/confirm")
    public ResponseEntity<UserInfo> confirm(HttpServletRequest request){
        return new ResponseEntity<>(userService.loginConfirmUserID(request), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}