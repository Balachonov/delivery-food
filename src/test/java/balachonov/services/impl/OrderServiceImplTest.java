package balachonov.services.impl;

import balachonov.arguments.orders.*;
import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import balachonov.entities.Order;
import balachonov.mappers.OrderMapperDto;
import balachonov.repositories.OrderRepository;
import balachonov.services.EmailService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("OrderService test")
class OrderServiceImplTest {

    @Mock
    private EmailService emailService;
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderMapperDto orderMapperDto;

    @BeforeEach
    void init() {
        orderServiceImpl = new OrderServiceImpl(emailService, orderRepository, orderMapperDto);
    }

    @ParameterizedTest
    @ArgumentsSource(InputOrder.class)
    void saveOrder(OrderRequest orderRequest, Order order, OrderResponse expecedOrderResponse) {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        OrderResponse actualOrderResponse = orderServiceImpl.saveOrder(orderRequest);
        assertEquals(expecedOrderResponse, actualOrderResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputOrder.class)
    void getOrderById(Order order, OrderResponse expecedOrderResponse) {
        when(orderRepository.findById(any(UUID.class))).thenReturn(ofNullable(order));
        OrderResponse actualOrderResponse = orderServiceImpl.getOrderById(order.getId());
        assertEquals(expecedOrderResponse, actualOrderResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(UpdatedOrder.class)
    void updateOrder(OrderRequest orderRequest, Order order, OrderResponse expecedOrderResponse) {
        when(orderRepository.findById(any(UUID.class))).thenReturn(ofNullable(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        OrderResponse actualOrderResponse = orderServiceImpl.updateOrder(orderRequest, order.getId());
        assertEquals(expecedOrderResponse, actualOrderResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputOrder.class)
    void getOrders(Order order, OrderResponse expecedOrderResponse) {
        when(orderRepository.findAll()).thenReturn(List.of(order));
        List<OrderResponse> actualOrderResponse = orderServiceImpl.getOrders();
        assertEquals(List.of(expecedOrderResponse), actualOrderResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidOrder.class)
    void getOrderByIdException(Order order) {
        when(orderRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) orderServiceImpl.getOrderById(order.getId()));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidUpdatedOrder.class)
    void updateOrderException(OrderRequest orderRequest, UUID id) {
        when(orderRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) orderServiceImpl.updateOrder(orderRequest, id));
    }
}