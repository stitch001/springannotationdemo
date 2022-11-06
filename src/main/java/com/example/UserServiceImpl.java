package com.example;

import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Override
    public void AddUser(String username, int userAge) {
        System.out.println("Add user " + username + " age is " + userAge);
    }

    @Override
    public String GetUser(String username) {
        return "useranme" + "   GetUser";
    }
    
}
