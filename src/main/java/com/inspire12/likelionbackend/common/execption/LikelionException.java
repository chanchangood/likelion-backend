package com.inspire12.likelionbackend.common.execption;

import lombok.Getter;

@Getter
public class LikelionException extends RuntimeException {
    private final ErrorCode errorCode;

    public LikelionException() {
        super("likelion error: 500 커스텀 에러");
        this.errorCode = ErrorCode.Like_Lion_Error;
    }

    public LikelionException(ErrorCode errorCode) {
        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }
}
