package com.ptit.room.controller;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.exception.handler.CantCreateRoomException;
import com.ptit.room.exception.handler.RoomNotFoundException;
import com.ptit.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomRestController {

    private final static Logger logger = LoggerFactory.getLogger(RoomRestController.class);

    @Autowired
    private RoomService roomService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addNewRoom(@RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto addedRoom = roomService.addNewRoom(roomRequestDto);
        if (addedRoom != null) {
            return new ResponseEntity<>(addedRoom, HttpStatus.OK);
        }
        else {
            throw new CantCreateRoomException();
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updateRoom(@RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto updatedRoom = roomService.updateRoom(roomRequestDto);
        if(updatedRoom != null){
            logger.info("room is updated: {}", updatedRoom);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        }
        else {
            throw new RoomNotFoundException();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") int roomId){
        boolean resultDeleted = roomService.deleteRoomById(roomId);
        if (resultDeleted){
            return new ResponseEntity<>("delete success.", HttpStatus.OK);
        }
        else {
            throw new RoomNotFoundException();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getRoomById(@PathVariable("id") int roomId){
        RoomResponseDto roomResponseDto = roomService.getRoomById(roomId);
        if (roomResponseDto != null){
            return new ResponseEntity<>(roomResponseDto, HttpStatus.OK);
        }
        else {
            throw  new RoomNotFoundException();
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllRooms(){
        List<RoomResponseDto> rooms = roomService.getAllRooms();
        logger.info("list: {}", rooms);
        if (!rooms.isEmpty()){
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
        else {
            throw new RoomNotFoundException();
        }
    }
}
