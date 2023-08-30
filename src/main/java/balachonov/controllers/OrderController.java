package balachonov.controllers;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import balachonov.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/order")
    public OrderResponse saveOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }

    @GetMapping(value = "/orderById/{id}")
    public OrderResponse getOrderById(@PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    @PutMapping(value = "/order/{id}")
    public OrderResponse updateOrder(@Valid @RequestBody OrderRequest orderRequest, @PathVariable UUID id) {
        return orderService.updateOrder(orderRequest, id);
    }

    @DeleteMapping(value = "/order/{id}")
    public void deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
    }

    @GetMapping(value = "/orders")
    public List<OrderResponse> getPersons() {
        return orderService.getOrders();
    }
}