package balachonov.services.impl;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import balachonov.entities.Order;
import balachonov.mappers.OrderMapperDto;
import balachonov.repositories.OrderRepository;
import balachonov.services.EmailService;
import balachonov.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.ORDER_NOT_FOUND_BY_ID;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final EmailService emailService;
    private final OrderRepository orderRepository;
    private final OrderMapperDto orderMapper;


    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        Order order = orderMapper.mapToOrder(orderRequest);
        emailService.sendSuccessfulOrderMail(order.getPerson().getEmail());
        order = orderRepository.save(order);
        return orderMapper.mapToOrderResponse(order);
    }

    @Override
    public OrderResponse getOrderById(UUID id) {
        return orderRepository.findById(id)
                .map(orderMapper::mapToOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(ORDER_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest, UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(ORDER_NOT_FOUND_BY_ID, id)));
        orderMapper.updateOrder(orderRequest, order);
        order = orderRepository.save(order);
        return orderMapper.mapToOrderResponse(order);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToOrderResponse)
                .toList();
    }
}