package com.kartheek.ecommerce.features.address.service;


import com.kartheek.ecommerce.features.address.entity.Address;
import com.kartheek.ecommerce.features.address.model.AddressDTO;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(Address address, Long addressId);

    String deleteAddress(Long addressId);
}
