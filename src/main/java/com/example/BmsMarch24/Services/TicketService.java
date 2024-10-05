package com.example.BmsMarch24.Services;

import com.example.BmsMarch24.Models.Ticket;

import java.util.List;

public interface TicketService {
    //class To interface why ? -> To avoid DIP violation

    Ticket bookticket(int userId, int showId, List<Integer> showseatId);
}
