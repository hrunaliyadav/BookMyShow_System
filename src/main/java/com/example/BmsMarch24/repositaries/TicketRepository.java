package com.example.BmsMarch24.repositaries;

import com.example.BmsMarch24.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
