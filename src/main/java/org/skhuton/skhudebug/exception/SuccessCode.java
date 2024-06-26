package org.skhuton.skhudebug.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    /*201 CREATED*/
    BUGHUNT_CREATE_SUCCESS(HttpStatus.CREATED, "헌터 구하기 요청이 생성되었습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode(){
        return httpStatus.value();
    }
}