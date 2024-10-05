package com.example.BmsMarch24.dtos;

import com.example.BmsMarch24.Models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDtos {
    private Response response;
    private Ticket ticket;

}
