package com.ptit.room.service.iml;

import com.ptit.room.dto.RoomRequestDto;
import com.ptit.room.dto.RoomResponseDto;
import com.ptit.room.mapper.MappingData;
import com.ptit.room.model.Room;
import com.ptit.room.repository.RoomRepository;
import com.ptit.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceIml implements RoomService {

    private final static Logger logger = LoggerFactory.getLogger(RoomServiceIml.class);

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MappingData mappingData;

    @Override
    public RoomResponseDto addNewRoom(RoomRequestDto roomRequestDto) {
        Room room = mappingData.convertRoomRequestDtoToRoom(roomRequestDto);
        Room roomCreated = roomRepository.save(room);
        return mappingData.convertRoomToResponseDto(roomCreated);
    }

    @Override
    public RoomResponseDto updateRoom(RoomRequestDto roomRequestDto) {
        Room room = mappingData.convertRoomRequestDtoToRoom(roomRequestDto);
        Room updatedRoom = null;
        if (checkRoomExist(room)){
            updatedRoom = roomRepository.saveAndFlush(room);
        }
        return mappingData.convertRoomToResponseDto(updatedRoom);
    }

    @Override
    public RoomResponseDto deleteRoom(RoomRequestDto roomRequestDto) {
        Room room = mappingData.convertRoomRequestDtoToRoom(roomRequestDto);
        Room deletedRoom = null;
        if (checkRoomExist(room)){
            deletedRoom = roomRepository.deleteById(room.getId());
        }
        return mappingData.convertRoomToResponseDto(deletedRoom);
    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        List<Room> roomLists = roomRepository.findAll();
        return mappingData.convertRoomListToRoomResponseDtoList(roomLists);
    }

    @Override
    public RoomResponseDto getRoomById(int roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        return mappingData.convertRoomToResponseDto(room);
    }

    private boolean checkRoomExist(Room room){
        Room roomExist = roomRepository.findById(room.getId()).orElse(null);
        if (roomExist == null){
            return false;
        }
        return true;
    }
}
