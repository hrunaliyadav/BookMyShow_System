package com.example.BmsMarch24.Controller;

import com.example.BmsMarch24.Models.Ticket;
import com.example.BmsMarch24.enums.ResponseStatus;
import com.example.BmsMarch24.Services.TicketService;
import com.example.BmsMarch24.dtos.BookTicketRequestDtos;
import com.example.BmsMarch24.dtos.BookTicketResponseDtos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TicketControllerTest {
    void foo() throws Exception {
    }
    @MockBean
    private TicketService ticketService;
    @Autowired
    private TicketController ticketController;

    @Test
    public void testBookTicket_ShowIdNegative() throws Exception {
        //Arrange
        BookTicketRequestDtos requestDto = new BookTicketRequestDtos();
        requestDto.setShowId(-1); // Invalid Show ID to trigger failure
        requestDto.setUserId(1);
        requestDto.setShowseatId(List.of(1,2,3,4));  // Valid seat IDs

        when(ticketService.bookticket(
                requestDto.getUserId(),
                requestDto.getShowId(),
                requestDto.getShowseatId()
        )).thenThrow(new RuntimeException("Invalid Show ID"));


        // Act
        BookTicketResponseDtos responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILURE, responseDto.getResponse().getResponseStatus());
        assertNotNull(responseDto.getResponse().getError());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testBookTicket_UserIdNegative() throws Exception {
        //Arrange
        BookTicketRequestDtos requestDto = new BookTicketRequestDtos();
        requestDto.setShowId(1);
        requestDto.setUserId(-1); // Invalid User ID
        requestDto.setShowseatId(List.of(1, 2, 3, 4)); // Valid seat IDs

        when(ticketService.bookticket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowseatId())).thenThrow(new IllegalArgumentException("Invalid User ID"));

        // Act
        BookTicketResponseDtos responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse(), "Response should not be null");
        assertEquals(ResponseStatus.FAILURE, responseDto.getResponse().getResponseStatus(), "Response status should be FAILURE");
        assertNotNull(responseDto.getResponse().getError(), "Error message should not be null");
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testBookTicket_Show_SeatIdNullNegative() throws Exception {
        //Arrange
        BookTicketRequestDtos requestDto = new BookTicketRequestDtos();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowseatId(List.of());

        when(ticketService.bookticket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowseatId()))
                .thenThrow(new IllegalArgumentException("Seat ID list cannot be empty"));

        // Act
        BookTicketResponseDtos responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse(), "Response should not be null");
        assertEquals(ResponseStatus.FAILURE, responseDto.getResponse().getResponseStatus(), "Response status should be FAILURE");
        assertNotNull(responseDto.getResponse().getError(), "Error message should not be null");
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testshow_seatIdNegative() throws Exception {
        //Arrange
        BookTicketRequestDtos requestDto = new BookTicketRequestDtos();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowseatId(null);

        when(ticketService.bookticket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowseatId()))
                .thenThrow(new IllegalArgumentException("Seat ID list cannot be null"));

        // Act
        BookTicketResponseDtos responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse(), "Response should not be null");
        assertEquals(ResponseStatus.FAILURE, responseDto.getResponse().getResponseStatus(), "Response status should be FAILURE");
        assertNotNull(responseDto.getResponse().getError(), "Error message should not be null");
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testBookTicket_Positive(){
        //Arrange
        BookTicketRequestDtos requestDto = new BookTicketRequestDtos();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowseatId(List.of(1,2,3,4));

        when(ticketService.bookticket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowseatId())).thenReturn(new Ticket());

        // Act
        BookTicketResponseDtos responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse(), "Response should not be null");
        assertEquals(ResponseStatus.SUCCESS, responseDto.getResponse().getResponseStatus(), "Response status should be SUCCESS");
        assertNull(responseDto.getResponse().getError(), "Error should be null for a successful booking");
        assertNotNull(responseDto.getTicket(), "Ticket should be generated");
    }

}