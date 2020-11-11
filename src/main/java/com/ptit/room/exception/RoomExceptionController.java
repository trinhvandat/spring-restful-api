package com.ptit.room.exception;

import com.ptit.room.exception.handler.BadRequestException;
import com.ptit.room.exception.handler.CantCreateRoomException;
import com.ptit.room.exception.handler.RoomNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(RoomExceptionController.class);

    @ExceptionHandler(value = RoomNotFoundException.class)
    public ResponseEntity<?> exceptionNotFound(RoomNotFoundException exception){
        logger.error("The room don't exist.");
        return new ResponseEntity<>("room not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException exception){
        logger.error("bad request. Please check your input data.");
        return new ResponseEntity<>("bad request",  HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CantCreateRoomException.class)
    public ResponseEntity<?> notCreateRoomException(CantCreateRoomException exception){
        logger.error("create room fail.");
        return new ResponseEntity<>("create room fail.", HttpStatus.SEE_OTHER);
    }
}
