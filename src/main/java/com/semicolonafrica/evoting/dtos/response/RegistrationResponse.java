package com.semicolonafrica.evoting.dtos.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public record RegistrationResponse(String message, HttpStatus httpStatus) {
}
