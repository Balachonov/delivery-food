package balachonov.services;

import balachonov.dto.requests.BasketRequest;
import balachonov.dto.responses.BasketResponse;

import java.util.List;
import java.util.UUID;

public interface BasketService {
    BasketResponse saveBasket(BasketRequest basketDtoRequest);

    BasketResponse readBasketById(UUID id);

    List<BasketResponse> getAllActiveBaskets();

    List<BasketResponse> getAllBaskets();

    List<BasketResponse> readArchiveBaskets();

    BasketResponse deleteBasket(String id);
}