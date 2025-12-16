package com.application.controller.exception;

import com.application.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerExceptionHandler {
  public ResponseEntity<StandardError> objectNotFoundException(
          ObjectNotFoundException objectNotFoundException,
          HttpServletRequest request
  ) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError standardError = new StandardError(
            System.currentTimeMillis(),
            status.value(),
            "Not Found",
            objectNotFoundException.getMessage(),
            request.getRequestURI()
    );
    return ResponseEntity.status(404).body(standardError);
  }
}
