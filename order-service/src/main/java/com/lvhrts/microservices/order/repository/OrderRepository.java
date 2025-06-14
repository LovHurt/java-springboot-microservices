package com.lvhrts.microservices.order.repository;

import com.lvhrts.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
