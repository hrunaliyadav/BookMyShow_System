package com.example.BmsMarch24.Models;

import com.example.BmsMarch24.enums.Seat_Type;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "seat_type_show")
public class SeatType_Show extends BaseModel{
    private Seat_Type seatType;
    @ManyToOne
    private Show show;
    private double price;
}
