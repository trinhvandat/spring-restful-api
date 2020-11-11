package com.ptit.room.service;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.model.Room;

import java.util.List;

public interface RoomService {

    public RoomResponseDto addNewRoom(RoomRequestDto roomRequestDto);

    public RoomResponseDto updateRoom(RoomRequestDto roomRequestDto);

    public boolean deleteRoomById(int roomId);

    public List<RoomResponseDto> getAllRooms();

    public RoomResponseDto getRoomById(int roomId);

}
