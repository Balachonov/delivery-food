package balachonov.services;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    /**
     * Saving Order
     * @return OrderResponse
     */

    OrderResponse saveOrder(OrderRequest orderRequest);

    /**
     * Getting Order by ID
     * @return DishResponse
     */

    OrderResponse getOrderById(UUID id);

    /**
     * Getting all Order
     * @return List of OrderResponse
     */

    List<OrderResponse> getOrders();

    /**
     * Updating Order
     * @return OrderResponse
     */

    OrderResponse updateOrder(OrderRequest orderRequest, UUID id);

    /**
     * Deleting Order by ID
     */

    void deleteOrder(UUID id);
}