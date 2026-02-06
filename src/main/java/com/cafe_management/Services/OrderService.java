package com.cafe_management.Services;

import com.cafe_management.Model.Order;
import com.cafe_management.Repository.OrderRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public Order createOrder(Order order) {
        order.setStatus("PENDING");
        order.setOrderTime(LocalDateTime.now());
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepo.findById(id).orElseThrow();
        order.setStatus(status);
        return orderRepo.save(order);
    }

    public List<Order> getTodayOrders() {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        return orderRepo.findByOrderTimeBetween(startOfDay, endOfDay);
    }
    public List<Order> getOrdersByStatus(String status) {
        return orderRepo.findByStatus(status);
    }
}