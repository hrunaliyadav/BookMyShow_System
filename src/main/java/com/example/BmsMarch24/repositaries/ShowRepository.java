package com.example.BmsMarch24.repositaries;

import com.example.BmsMarch24.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    Optional<Show> findById(int showId);
}
