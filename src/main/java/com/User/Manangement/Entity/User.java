package com.User.Manangement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String city;
    private int age;
    private long phoneNumber;
    private String email;


}
