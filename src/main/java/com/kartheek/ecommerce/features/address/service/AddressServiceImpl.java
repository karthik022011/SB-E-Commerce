package com.kartheek.ecommerce.features.address.service;

import com.kartheek.ecommerce.features.address.entity.Address;
import com.kartheek.ecommerce.features.address.model.AddressDTO;
import com.kartheek.ecommerce.features.address.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public AddressDTO updateAddress(Address address, Long addressId) {
        return null;
    }

    @Override
    public String deleteAddress(Long addressId) {
        return null;
    }
}
