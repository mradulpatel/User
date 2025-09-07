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

     @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id)
     {
         User user=  userservice.getUserById(id);
//         int a= 5;
         if(user!=null){
             return new ResponseEntity<>(user,HttpStatus.OK);
         }
         else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

     }
     @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User user)
     {
        User updatedUser= userservice.updateUser(id,user);
        if(updatedUser!= null)
        {
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
        }

      else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
     }
     @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {

         boolean status = userservice.deleteUser(id);
         if (status) {
             return new ResponseEntity<>("UserDeletedSuccessfully", HttpStatus.OK);
         } else {
             return new ResponseEntity<>("UserNotFound", HttpStatus.NOT_FOUND);
         }
     }
    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<String> deleteAllUsers() {
        boolean status = userservice.deleteAllUsers();

        if (status) {
            return new ResponseEntity<>("All users deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete users.", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/ageRange")
    public ResponseEntity<List<User>>
    getUserByAgeRange(@RequestParam int startAge,@RequestParam int endAge)

    {
        List<User> userList = userservice.getUserByAgeRange(startAge , endAge);
        if(userList!=null){
            return new ResponseEntity<>(userList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
         }


