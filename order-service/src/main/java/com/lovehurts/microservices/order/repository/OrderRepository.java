package com.lovehurts.microservices.order.repository;

import com.lovehurts.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
