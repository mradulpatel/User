package com.User.Manangement.Service;


import com.User.Manangement.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    User createUser(User user);

    List<User> getUsers();
}
