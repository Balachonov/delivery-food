package balachonov.services;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    OrderResponse saveOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(UUID id);

    List<OrderResponse> getOrders();

    OrderResponse updateOrder(OrderRequest orderRequest, UUID id);

    void deleteOrder(UUID id);
}