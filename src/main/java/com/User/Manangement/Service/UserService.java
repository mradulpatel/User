package com.User.Manangement.Service;


import com.User.Manangement.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    User createUser(User user);

    List<User> getUsers();

    User getUserById(String id);


    User updateUser(String id, User user);

    boolean deleteUser(String id);


    boolean deleteAllUsers();

    List<User> getUserByAgeRange(int startAge, int endAge);
}
