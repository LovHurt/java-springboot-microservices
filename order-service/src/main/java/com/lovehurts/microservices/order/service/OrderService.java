package com.lovehurts.microservices.order.service;

import com.lovehurts.microservices.order.dto.OrderRequest;
import com.lovehurts.microservices.order.model.Order;
import com.lovehurts.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        //map orderreq to order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        //save order to orderrepository
        orderRepository.save(order);
    }
}
