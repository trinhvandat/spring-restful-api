package com.ptit.room.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptit.room.enumeration.RoomType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RoomResponseDto implements Serializable {

    @JsonProperty("room_id")
    private int roomId;

    @JsonProperty("room_name")
    private String roomName;

    @JsonProperty("room_type")
    private RoomType roomType;

    @JsonProperty("room_acreage")
    private float roomAcreage;

}
