package com.ptit.room.model;

import com.ptit.room.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String roomName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "acreage")
    private float roomAcreage;

}
