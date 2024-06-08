package com.kartheek.ecommerce.features.address.service;

import com.kartheek.ecommerce.features.address.entity.Address;
import com.kartheek.ecommerce.features.address.model.AddressDTO;
import com.kartheek.ecommerce.features.address.repository.AddressRepository;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import com.kartheek.ecommerce.user.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Optional<RegisterUser> user = userInfoRepository.findById(addressDTO.getUserId());
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setUser(user.get());
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAllAddressByUserId(Long userId) {
        List<Address> addresses = addressRepository.findByUserUserId(userId);
        Type listType = new TypeToken<List<AddressDTO>>(){}.getType();
        return modelMapper.map(addresses, listType);
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
