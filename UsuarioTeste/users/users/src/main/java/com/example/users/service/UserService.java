package com.example.users.service;

import com.example.users.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final List<User> userList;

    public UserService(){
        userList = new ArrayList<>();
        User user1 = new User(1,"Maria",21,"maria@gmail.com");
        User user2 = new User(2,"Joao",22,"joao@gmail.com");
        User user3 = new User(3,"José",23,"jose@gmail.com");
        User user4 = new User(4,"Luiz",24,"luiz@gmail.com");
        User user5 = new User(5,"Joice",25,"joice@gmail.com");
        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> GetUserById(int id){
        Optional<User> optional = Optional.empty();
        for (User user: userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public User addUser(User user) {
        User teste = new User(user.getId(), user.getName(), user.getAge(), user.getEmail());
        userList.add(teste);
        return teste;
    }

}

