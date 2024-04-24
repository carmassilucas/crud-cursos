package br.com.ignite.rocketseat.crudcursos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationExceptionDto>> handlerConstraintViolationException(
            MethodArgumentNotValidException exception
    ) {
        var errors = new ArrayList<ValidationExceptionDto>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                errors.add(new ValidationExceptionDto(
                        fieldError.getDefaultMessage(),
                        fieldError.getField()
                ))
        );

        return ResponseEntity.badRequest().body(errors);
    }
}
