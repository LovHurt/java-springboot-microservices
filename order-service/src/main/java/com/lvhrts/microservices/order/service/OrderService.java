package com.lvhrts.microservices.order.service;

import com.lvhrts.microservices.order.client.InventoryClient;
import com.lvhrts.microservices.order.dto.OrderRequest;
import com.lvhrts.microservices.order.model.Order;
import com.lvhrts.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        }
        else {
            throw new RuntimeException("product with skucode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
