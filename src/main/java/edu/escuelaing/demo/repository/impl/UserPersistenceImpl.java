package edu.escuelaing.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import edu.escuelaing.demo.model.User;
import edu.escuelaing.demo.repository.UserPersistence;


@Service
public class UserPersistenceImpl implements UserPersistence {
    ConcurrentHashMap<String, User> users= new ConcurrentHashMap<>();
    public UserPersistenceImpl(){
        User us1=new User("yowis","yohanna","web UI","123");
        User us2=new User("ion","johnsina","backend","1234");
        User us3=new User("gordis","albert","backend","1235");
        users.put("yowis", us1);
        users.put("ion", us2);
        users.put("gordis", us3);
    }

    @Override
    public List<User> getUsersList() {
        List<User> us= new ArrayList<>();
        for(User u:users.values()){
            us.add(u);
        }

        return us;
 
    }

    @Override
    public User getUserById(String userId) {
        User user=users.get(userId);
        return user;
    }

    @Override
    public void createUser(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUser(String userId) {
        // TODO Auto-generated method stub

    }

}