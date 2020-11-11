package com.ptit.room.controller;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.exception.handler.RoomNotFoundException;
import com.ptit.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomRestController {

    private final static Logger logger = LoggerFactory.getLogger(RoomRestController.class);

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> addNewRoom(@RequestBody RoomRequestDto roomRequestDto){
        RoomResponseDto addedRoom = roomService.addNewRoom(roomRequestDto);
        if (addedRoom == null) throw new RoomNotFoundException();
        else {
            return new ResponseEntity<>(addedRoom, HttpStatus.OK);
        }
    }

}
