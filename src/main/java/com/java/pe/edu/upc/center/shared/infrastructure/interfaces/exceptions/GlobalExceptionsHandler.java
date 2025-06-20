package com.java.pe.edu.upc.center.shared.infrastructure.interfaces.exceptions;


import com.java.pe.edu.upc.center.shared.domain.exceptions.AdvisorNotFoundException;
import com.java.pe.edu.upc.center.shared.domain.exceptions.FarmerNotFoundException;
import com.java.pe.edu.upc.center.shared.domain.exceptions.UserNotFoundException;
import com.java.pe.edu.upc.center.shared.infrastructure.interfaces.responses.ErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionsHandler {
    // Maneja excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Internal Server Error", "Ocurrió un error inesperado.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Jakarta Validations
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleConstraintViolationException(ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Constraint Violation", errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(UserNotFoundException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("User Not Found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdvisorNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAdvisorNotFoundException(AdvisorNotFoundException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Advisor Not Found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FarmerNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleFarmerNotFoundException(FarmerNotFoundException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Farmer Not Found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
