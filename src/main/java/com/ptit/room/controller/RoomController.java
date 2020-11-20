package com.ptit.room.controller;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.enumeration.RoomType;
import com.ptit.room.model.Room;
import com.ptit.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomService roomService;

    @ModelAttribute()
    public void addTypeRoomToModel(Model model){
        RoomType[] roomTypes = RoomType.values();

        List<RoomResponseDto> rooms = roomService.getAllRooms();
        model.addAttribute("roomLists", rooms);
        model.addAttribute("roomType", roomTypes);
    }

    @GetMapping
    public String showIndexForm(){
        return "rooms";
    }

    @PostMapping("/rooms")
    public String showFormAddRoom(Model model){
        model.addAttribute("room", new RoomRequestDto());
        return "addRoom";
    }

    @PostMapping("/rooms/add")
    public String addRoom(RoomRequestDto room){
        logger.info("room: {}", room);
        roomService.addNewRoom(room);
        return "redirect:/";
    }

    @PostMapping("/rooms/update")
    public String updateRoom(RoomRequestDto room){
        logger.info("room: {}", room);
        RoomResponseDto responseDto = roomService.updateRoom(room);
        logger.info("response: {}", responseDto);
        return "redirect:/";
    }

    @GetMapping("/rooms")
    public String getListRoom(Model model){
        List<RoomResponseDto> rooms = roomService.getAllRooms();
        model.addAttribute("roomLists", rooms);
        return "rooms";
    }

    @GetMapping(value = "/rooms/{id}")
    public String updateRoomForm(@PathVariable int id, Model model){
        RoomResponseDto room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "update";
    }

    @PostMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable int id){
        roomService.deleteRoomById(id);
        return "redirect:/";
    }

}
