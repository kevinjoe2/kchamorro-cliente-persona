package com.neoris.clientepersona.exceptions;

import lombok.Builder;

public class ClientePersonaException extends RuntimeException{

    @Builder
    public ClientePersonaException(String message, Throwable cause) {
        super(message, cause);
    }
}
