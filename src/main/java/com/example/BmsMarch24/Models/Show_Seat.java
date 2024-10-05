package com.example.BmsMarch24.Models;

import com.example.BmsMarch24.enums.SEAT_STATUS;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "show_seats")
public class Show_Seat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated(value = EnumType.ORDINAL)
    private SEAT_STATUS seatStatus;
    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Ticket ticket;
}
