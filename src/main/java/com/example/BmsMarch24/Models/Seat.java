package com.example.BmsMarch24.Models;

import com.example.BmsMarch24.enums.SEAT_STATUS;
import com.example.BmsMarch24.enums.Seat_Type;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String name;
    Seat_Type seatType;
    SEAT_STATUS seatStatus;
    @ManyToOne
    private Screen screen;
}
