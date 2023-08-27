package balachonov.services;

import balachonov.dto.requests.AddressRequest;
import balachonov.dto.responses.AddressResponse;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    AddressResponse saveAddress(AddressRequest addressDtoRequest);

    AddressResponse readAddressById(UUID id);

    List<AddressResponse> getAllAddresses();

    AddressResponse deleteAddress(String id);
}