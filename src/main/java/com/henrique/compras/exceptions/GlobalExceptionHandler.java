package com.henrique.compras.exceptions;

import com.henrique.compras.api.response.ErrorResponse;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getAllErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(
            ErrorResponse.builder().message(errors).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleValidationExceptions(EntidadeNaoEncontradaException ex) {
        String errors = ex.getMessage();
        return new ResponseEntity<>(ErrorResponse.builder().message(errors).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleValidationExceptions(Throwable ex) {
        return new ResponseEntity<>(ErrorResponse.builder().message("Erro desconhecido, favor entrar em contato com o suporte").build(), HttpStatus.BAD_REQUEST);
    }
}
