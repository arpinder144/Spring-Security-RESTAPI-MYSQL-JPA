package com.example.springpractice.service;

import com.example.springpractice.model.Roles;
import com.example.springpractice.model.UserInfo;
import com.example.springpractice.model.UserModel;
import com.example.springpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserRepository userRepository;

   @Autowired
    PasswordEncoder passwordEncoder;

    public UserInfo SaveUserData(UserModel userModel){
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(userModel.getUsername());
        userInfo.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userInfo.setRoles(userModel.getRoles());
        userInfo.setActive(true);
        userRepository.save(userInfo);
        return userInfo;
    }
}
