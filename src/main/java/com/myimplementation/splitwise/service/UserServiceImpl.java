package com.myimplementation.splitwise.service;

import com.myimplementation.splitwise.exceptions.UserAlreadyExistsException;
import com.myimplementation.splitwise.models.User;
import com.myimplementation.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String name, String password, String phone) throws Exception {

        long phoneLong=Long.parseLong(phone); //cannot have int data type since int can hold 2*10^9 value only
        //Validation for user already present with name
        Optional<User> userCheck = userRepository.findUserByNameAndPhone(name,phoneLong );

        if(userCheck.isPresent()){
            throw new UserAlreadyExistsException("User already exists");
        }

        //Validation Done
        User user=new User();

        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phoneLong);

        return userRepository.save(user);
    }
}
