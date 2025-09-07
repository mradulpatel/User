package com.User.Manangement.ServiceImpl;

import com.User.Manangement.Entity.User;
import com.User.Manangement.Repository.UserRepo;
import com.User.Manangement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepo.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();

    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(String id, User user) {
        User oldUser = userRepo.findById(id).orElse(null);
        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setAge(user.getAge());
            oldUser.setCity(user.getCity());
           oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setEmail(user.getEmail());

            return userRepo.save(oldUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(String id) {

        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override

    public boolean deleteAllUsers() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return false;
        } else {
            userRepo.deleteAll();
            return true;
        }
    }

    @Override
    public List<User> getUserByAgeRange(int startAge, int endAge) {
        List<User> userListWithAgeRange = userRepo.findByAgeBetween(startAge, endAge);
    if(userListWithAgeRange.isEmpty()){
        return null;
    }
    else{
        return userListWithAgeRange;
    }
    }
}



