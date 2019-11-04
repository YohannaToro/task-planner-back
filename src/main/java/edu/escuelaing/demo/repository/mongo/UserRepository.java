package edu.escuelaing.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.demo.model.User;

public interface UserRepository extends MongoRepository<User,String>{

    User findByName(String name);
    
}