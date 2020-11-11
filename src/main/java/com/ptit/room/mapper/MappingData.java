package com.ptit.room.mapper;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

@Component
public class MappingData {


    public RoomResponseDto convertRoomToResponseDto(Room room){
        RoomResponseDto dto = null;
        if (room != null){
            dto = RoomResponseDto.builder()
                    .roomId(room.getId())
                    .roomAcreage(room.getRoomAcreage())
                    .roomType(room.getRoomType())
                    .roomName(room.getRoomName())
                    .build();
        }
        return dto;
    }

    public List<RoomResponseDto> convertRoomListToRoomResponseDtoList(List<Room> roomList){
        if (roomList != null){
            return roomList.stream().map(this::convertRoomToResponseDto).collect(toList());
        }
        return null;
    }

    public Room convertRoomRequestDtoToRoom(RoomRequestDto roomRequestDto){
        Room room = null;
        if (roomRequestDto != null){
            room = Room.builder()
                    .id(roomRequestDto.getRoomId())
                    .roomAcreage(roomRequestDto.getRoomAcreage())
                    .roomName(roomRequestDto.getRoomName())
                    .roomType(roomRequestDto.getRoomType())
                    .build();
        }
        return room;
    }

}
