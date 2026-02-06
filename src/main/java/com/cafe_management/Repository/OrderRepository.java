package com.cafe_management.Repository;

import com.cafe_management.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
    List<Order> findByStatus(String status);
    List<Order> findByOrderTimeBetween(LocalDateTime start, LocalDateTime end);
}
