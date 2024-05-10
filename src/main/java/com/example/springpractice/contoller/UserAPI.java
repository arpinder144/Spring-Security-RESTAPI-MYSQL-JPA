package com.example.springpractice.contoller;

import com.example.springpractice.model.UserInfo;
import com.example.springpractice.model.UserModel;
import com.example.springpractice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class UserAPI {

    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/register")
    public String saveUserData(@RequestBody UserModel userModel){
        userInfoService.SaveUserData(userModel);
        return "User Registered successfully!!";
    }









    @GetMapping("/get")
    public String home(){
        return "Welcome to Application";
    }
    @GetMapping("check")
    public String withSecurityCheck(){
        return "With Security Check";
    }
    @GetMapping("notCheck")
    public String withOutSecurityCheck(){
        return "WithOut Security Check";
    }

}
