    package com.example.BmsMarch24.dtos;

    import lombok.Data;
    import java.util.List;
    @Data
    public class BookTicketRequestDtos {
        private int userId;
        private int showId;
        private List<Integer> showseatId;
    }
