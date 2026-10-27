package br.com.northwind.controller.exceptionhandler;

import br.com.northwind.service.exception.NorthwindException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class NorthwindExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NorthwindException.class)
    public ResponseEntity<ErroResponse> handleNorthwindException(NorthwindException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class ErroResponse {
        int status;
        String mensagem;
    }
}