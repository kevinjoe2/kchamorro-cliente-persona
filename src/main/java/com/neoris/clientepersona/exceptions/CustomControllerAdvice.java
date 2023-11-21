package com.neoris.clientepersona.exceptions;

import com.neoris.clientepersona.vos.ErrorVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ClientePersonaException.class)
    public ResponseEntity<ErrorVo> handleResourceNotFoundException(ClientePersonaException ex) {
        return ResponseEntity.badRequest()
                .body(ErrorVo.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .error(ex.getMessage())
                        .build());
    }
}
