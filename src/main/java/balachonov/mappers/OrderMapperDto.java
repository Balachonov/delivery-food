package balachonov.mappers;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import balachonov.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(uses = {DishMapperDto.class},
        componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE)
public interface OrderMapperDto {

    @Mapping(source = ORDER_DISHES, target = DISH_RESPONSES)
    OrderResponse mapToOrderResponse(Order order);

    Order mapToOrder(OrderResponse orderResponse);
    Order mapToOrder(OrderRequest orderRequest);

    void updateOrder(OrderRequest orderRequest, @MappingTarget Order order);
}
