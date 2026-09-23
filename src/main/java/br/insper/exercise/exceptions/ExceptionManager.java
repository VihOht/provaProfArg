package br.insper.exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(TarefaNotFound.class)
    public ResponseEntity<String> HandleTarefaNotFound(TarefaNotFound exception) {
        return new ResponseEntity<>("Tarefa not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObserveNotFound.class)
    public ResponseEntity<String> HandleObserveNotFound(ObserveNotFound exception) {
        return new ResponseEntity<>("Observe not found", HttpStatus.NOT_FOUND);
    }
}
