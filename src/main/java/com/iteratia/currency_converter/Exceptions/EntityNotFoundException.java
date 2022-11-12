package com.iteratia.currency_converter.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
@Slf4j
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        log.error(message);
    }
}
