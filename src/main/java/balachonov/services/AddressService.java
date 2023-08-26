package balachonov.services;

import balachonov.dto.requests.AddressDtoRequest;
import balachonov.dto.responses.AddressDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AddressService {
    AddressDtoResponse saveAddress(AddressDtoRequest addressDtoRequest);

    AddressDtoResponse readAddressById(UUID id);

    List<AddressDtoResponse> getAllAddresses();
    AddressDtoResponse deleteAddress(String id);
}