package org.skhuton.skhudebug.exception.model;


import org.skhuton.skhudebug.exception.ErrorCode;

public class NotFoundException extends CustomException {
    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
