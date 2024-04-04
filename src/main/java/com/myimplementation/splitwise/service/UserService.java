package com.myimplementation.splitwise.service;

import com.myimplementation.splitwise.models.User;

public interface UserService {
    User register(String name,String password,String phone) throws Exception;
}
