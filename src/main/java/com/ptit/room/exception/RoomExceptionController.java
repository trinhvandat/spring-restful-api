package com.ptit.room.exception;

import com.ptit.room.exception.handler.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomExceptionController {

    @ExceptionHandler(value = RoomNotFoundException.class)
    public ResponseEntity<?> exceptionNotFound(RoomNotFoundException exception){
        return new ResponseEntity<>("room not found", HttpStatus.NOT_FOUND);
    }

}
