package com.ptit.room.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptit.room.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDto implements Serializable {

    @JsonProperty("room_id")
    private int roomId;

    @JsonProperty("room_name")
    private String roomName;

    @JsonProperty("room_type")
    private RoomType roomType;

    @JsonProperty("room_acreage")
    private float roomAcreage;

}
