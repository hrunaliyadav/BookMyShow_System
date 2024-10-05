package com.example.BmsMarch24.Services;

import com.example.BmsMarch24.repositaries.ShowRepository;
import com.example.BmsMarch24.repositaries.ShowSeatRepository;
import com.example.BmsMarch24.repositaries.TicketRepository;
import com.example.BmsMarch24.repositaries.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TicketServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ShowSeatRepository showSeatRepository;

    @MockBean
    private ShowRepository showRepository;

    @MockBean   
    private TicketRepository ticketRepository;

    //TODO :
    TicketServiceImplTest() {
    }
}