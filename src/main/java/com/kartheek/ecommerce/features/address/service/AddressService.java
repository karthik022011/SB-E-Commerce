package com.kartheek.ecommerce.features.address.service;


import com.kartheek.ecommerce.features.address.entity.Address;
import com.kartheek.ecommerce.features.address.model.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO);

    List<AddressDTO> getAddressByUserId(Long userId);


    AddressDTO updateAddress(Address address, Long addressId);

    String deleteAddress(Long addressId);
}
