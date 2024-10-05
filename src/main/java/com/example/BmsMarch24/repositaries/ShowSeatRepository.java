package com.example.BmsMarch24.repositaries;

import com.example.BmsMarch24.Models.Show;
import com.example.BmsMarch24.Models.Show_Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<Show_Seat, Integer> {
        Optional<Show_Seat> findById(int showseatId);
//        @Lock(value = LockModeType.PESSIMISTIC_WRITE)  //for update
//        List<Show_Seat> findShowSeatsByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show);//Select query

        Show_Seat save(Show_Seat seat);
}
