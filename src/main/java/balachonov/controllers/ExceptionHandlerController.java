package balachonov.controllers;

import balachonov.dto.responses.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static balachonov.util.Constants.*;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserNotFoundException(EntityNotFoundException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
        return ErrorResponse.builder()
                .message(LOG_ERR_NOT_FOUND_PERSON)
                .helpEmail(WRITE_TO_US + COMPANY_GMAIL)
                .time(LocalDateTime.now())
                .build();
    }
}
