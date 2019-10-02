package edu.escuelaing.demo.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.escuelaing.demo.model.User;

public interface UserPersistence {
    public List<User> getUsersList();
    
    public User getUserById(String userId);
    
    public void createUser(User user);
    
    public void updateUser(User user);
    
    public void removeUser(String userId);
    
}