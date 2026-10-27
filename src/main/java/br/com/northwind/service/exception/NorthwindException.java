package br.com.northwind.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NorthwindException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NorthwindException(String message) {
        this(message, null);
    }

    public NorthwindException(String message, Throwable cause) {
        super(message, cause);
    }
}