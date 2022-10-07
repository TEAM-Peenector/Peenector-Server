package com.deploy.peenector.common.exception.model;

import com.deploy.peenector.common.exception.ErrorCode;

public class ValidationException extends PeenectorException {
    public ValidationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ValidationException(String message) {
        super(message, ErrorCode.VALIDATION_EXCEPTION);
    }
}
