package com.neoris.clientepersona.exceptions;

import lombok.Builder;

public class ClientePersonaException extends RuntimeException{

    @Builder(builderMethodName = "message")
    public ClientePersonaException(String message) {
        super(message);
    }

    @Builder(builderMethodName = "throwable")
    public ClientePersonaException(String message, Throwable cause) {
        super(message, cause);
    }
}
