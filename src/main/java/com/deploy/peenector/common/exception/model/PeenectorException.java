package com.deploy.peenector.common.exception.model;

import com.deploy.peenector.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class PeenectorException extends RuntimeException {
    private final ErrorCode errorCode;

    public PeenectorException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return errorCode.getStatus();
    }
}
