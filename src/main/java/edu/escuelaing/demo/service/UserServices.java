package edu.escuelaing.demo.service;

import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.TaskList;
import edu.escuelaing.demo.model.User;
import edu.escuelaing.demo.repository.TaskPlannerPersistence;
import edu.escuelaing.demo.repository.UserPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserPersistence userPersistence;
    
    public List<User> getUsersList(){
        return userPersistence.getUsersList();
    }
    
    public User getUserById(String userId){
        return userPersistence.getUserById(userId);
    }
    
    public void createUser(User user){
     userPersistence.createUser(user);
        }
    
    public void updateUser(User user){
        userPersistence.updateUser(user);
    }
    
    public void removeUser(String userId){
        userPersistence.removeUser(userId);
    }


}