package com.anil.abcschool.api;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiExceptionFormat(
        String message,
        ZonedDateTime zonedDateTime
) {
}
