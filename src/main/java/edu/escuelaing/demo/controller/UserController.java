package edu.escuelaing.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.demo.model.User;
import edu.escuelaing.demo.service.UserServices;

@RestController
@RequestMapping(value="/users")
@CrossOrigin
public class UserController{
    @Autowired
    UserServices userServices;
    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<User>> getUsersList() {

        List<User> data= userServices.getUsersList();
       // System.out.println(data.size());
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") String id){

        try {
            User data=userServices.getUserById(id);
            
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        }

    }
    

}