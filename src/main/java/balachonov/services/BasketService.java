package balachonov.services;

import balachonov.dto.requests.BasketDtoRequest;
import balachonov.dto.responses.BasketDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BasketService {
    BasketDtoResponse saveBasket(BasketDtoRequest basketDtoRequest);

    BasketDtoResponse readBasketById(UUID id);

    List<BasketDtoResponse> getAllActiveBaskets();

    List<BasketDtoResponse> getAllBaskets();

    List<BasketDtoResponse> readArchiveBaskets();

    BasketDtoResponse deleteBasket(String id);
}