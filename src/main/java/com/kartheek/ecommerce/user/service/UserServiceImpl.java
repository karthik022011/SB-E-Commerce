package com.kartheek.ecommerce.user.service;


import com.kartheek.ecommerce.user.model.request.RegisterReqDTO;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import com.kartheek.ecommerce.user.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public RegisterReqDTO createUser(RegisterReqDTO registerReqDTO) {
        RegisterUser user = modelMapper.map(registerReqDTO, RegisterUser.class);
        RegisterUser savedUser = userInfoRepository.save(user);
        return modelMapper.map(savedUser,RegisterReqDTO.class);
    }
}
