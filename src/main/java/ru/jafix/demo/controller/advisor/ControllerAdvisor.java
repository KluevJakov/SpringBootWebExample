package ru.jafix.demo.controller.advisor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.jafix.demo.model.ErrorDto;

@RestControllerAdvice
public class ControllerAdvisor {


    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        ObjectError objectError = e.getAllErrors().stream().findFirst().get();

        ErrorDto errorDto = ErrorDto.builder()
                .code(400)
                .description(objectError.getDefaultMessage())
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorDto);
    }

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {

        ErrorDto errorDto = ErrorDto.builder()
                .code(400)
                .description(e.getMessage())
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorDto);
    }

}
