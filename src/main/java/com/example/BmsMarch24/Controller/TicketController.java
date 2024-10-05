package com.example.BmsMarch24.Controller;

import com.example.BmsMarch24.Models.Ticket;
import com.example.BmsMarch24.Services.TicketService;
import com.example.BmsMarch24.dtos.BookTicketRequestDtos;
import com.example.BmsMarch24.dtos.BookTicketResponseDtos;
import com.example.BmsMarch24.dtos.Response;
import com.example.BmsMarch24.exceptions.InvalidBookTicketRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @RequestMapping(path = "/bookTicket")
    public BookTicketResponseDtos bookTicket(BookTicketRequestDtos requestDtos){
        BookTicketResponseDtos responseDtos = new BookTicketResponseDtos();
        try{
            validatebookticketRequest(requestDtos);
            Ticket ticket = ticketService.bookticket(requestDtos.getUserId(), requestDtos.getShowId(), requestDtos.getShowseatId());
            Response response = Response.getSuccessResponse();
            responseDtos.setTicket(ticket);
            responseDtos.setResponse(response);
            return responseDtos;
        }catch (Exception e){
            Response response = Response.getfailureResponse(e.getMessage());
            responseDtos.setResponse(response);
        }
        return responseDtos;
    }

    private static void validatebookticketRequest(BookTicketRequestDtos requestDtos){
        if(requestDtos.getShowId() <= 0){
            throw new InvalidBookTicketRequestException( "Show Id should not be Negative or 0");
        }
        if(requestDtos.getUserId() <=0){
            throw new InvalidBookTicketRequestException("User Id should not be Negative or 0");
        }
        if(requestDtos.getShowseatId() == null || requestDtos.getShowseatId().isEmpty()){
            throw new InvalidBookTicketRequestException("Seat Id should be present");
        }

    }


}
