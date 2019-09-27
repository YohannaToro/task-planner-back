package edu.escuelaing.demo.repository;

import java.util.List;

import edu.escuelaing.demo.model.User;

public interface UserPersistence {
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
}