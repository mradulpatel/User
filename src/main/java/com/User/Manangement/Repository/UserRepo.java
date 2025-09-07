package com.User.Manangement.Repository;

import com.User.Manangement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,String> {


List<User> findByAgeBetween(int startAge, int endAge);
}
