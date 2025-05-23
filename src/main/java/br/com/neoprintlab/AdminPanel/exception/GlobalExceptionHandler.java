package br.com.neoprintlab.AdminPanel.exception;

import br.com.neoprintlab.AdminPanel.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NumberOfPromptsExceededException.class)
    public ResponseEntity<ErrorResponseDto> handleLimitExceeded(NumberOfPromptsExceededException ex) {
        ErrorResponseDto error = new ErrorResponseDto("PROMPT_LIMIT_EXCEEDED", ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralError(Exception ex) {
        ErrorResponseDto error = new ErrorResponseDto("INTERNAL_ERROR", "An unexpected error occurred", System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
