package br.com.iteris.auth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid auth token")
public class InvalidTokenException extends RuntimeException {
}
