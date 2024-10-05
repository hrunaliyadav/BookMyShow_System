package com.example.BmsMarch24.repositaries;

import com.example.BmsMarch24.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int userId);
}
