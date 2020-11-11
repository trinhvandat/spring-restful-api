package com.ptit.room.controller;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.enumeration.RoomType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @ModelAttribute()
    public void addTypeRoomToModel(Model model){
        RoomType[] roomTypes = RoomType.values();
        List<String> rooms = new ArrayList<>();
        for (RoomType type : roomTypes){
            rooms.add(type.toString());
        }
        model.addAttribute("rooms", rooms);
        logger.info("list type: {}", rooms);
    }

    @GetMapping
    public String showIndexForm(){
        return "index";
    }

    @PostMapping("/rooms")
    public String showFormAddRoom(Model model){
        model.addAttribute("room", new RoomRequestDto());
        return "addRoom";
    }

}
