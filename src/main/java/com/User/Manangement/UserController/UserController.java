package com.User.Manangement.UserController;

import com.User.Manangement.Entity.User;
import com.User.Manangement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {


        User Saveduser=userservice.createUser(user);

        if(Saveduser!=null)
        {
            return new ResponseEntity<>(Saveduser,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> userList= userservice.getUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);


    }




}
