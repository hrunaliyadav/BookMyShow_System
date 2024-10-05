package com.example.BmsMarch24.Services;

import com.example.BmsMarch24.Models.*;
import com.example.BmsMarch24.enums.SEAT_STATUS;
import com.example.BmsMarch24.exceptions.InvalidBookTicketRequestException;
import com.example.BmsMarch24.exceptions.SeatUnavailableException;
import com.example.BmsMarch24.repositaries.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements  TicketService{
    private UserRepository userRespositary;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(UserRepository userRespositary, ShowRepository showRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository) {
        this.userRespositary = userRespositary;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookticket(int userId, int showId, List<Integer> showseatId) {

        //User validation
        Optional< User> userOptional = this.userRespositary.findById(userId);
        User user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new InvalidBookTicketRequestException("User is invalid");
        }

        //show validation
        Show show = this.showRepository
                .findById(showId).orElseThrow(()
                        -> new InvalidBookTicketRequestException("Show id invalid") );

        //show_seat validation
        Show_Seat showseat = this.showSeatRepository
                .findById(showseatId.get(0)).orElseThrow(()
                        -> new InvalidBookTicketRequestException("Seat id in invalid"));

        //Showid in showSeatIds and given showId should match
        if(showseat.getShow().getId() != showId){
            throw new InvalidBookTicketRequestException("Given seats dont belong to the same show");
        }

        //Select query
        List<Show_Seat> showSeats = null;//this.showSeatRepository.findShowSeatsByIdInAndSeatStatus_AvailableAndShow(showseatId, show);

        //check size of showseat
        if(showSeats.size() != showseatId.size()) {
            throw new SeatUnavailableException("Seats are unavailable");
        }

        for(Show_Seat ss : showSeats){
            ss.setBookedBy(user);
            ss.setSeatStatus(SEAT_STATUS.BOOKED);
        }
        showSeatRepository.saveAll(showSeats);

        Ticket ticket = new Ticket();
        ticket.setMovie(show.getMovie());
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setUser(user);
        return ticketRepository.save(ticket);

    }
}
