package hu.flowacademy.demo.rest;

import ch.qos.logback.core.encoder.EchoEncoder;
import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity handleNotFoundException(ContactNotFoundException e) {
    System.err.println(e.getMessage());
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(ContactValidationException.class)
  public ResponseEntity handleValidationException(ContactValidationException e) {
    return ResponseEntity.badRequest().body(List.of(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(List.of(e.getMessage()));
  }

}
