package com.User.Manangement.ServiceImpl;

import com.User.Manangement.Entity.User;
import com.User.Manangement.Repository.UserRepo;
import com.User.Manangement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {

       return userRepo.save(user);

    }
}
