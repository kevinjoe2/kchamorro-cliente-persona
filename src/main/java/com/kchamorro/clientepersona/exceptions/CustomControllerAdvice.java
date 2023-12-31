package com.kchamorro.clientepersona.exceptions;

import com.kchamorro.clientepersona.vos.ErrorVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
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
