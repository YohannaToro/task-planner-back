package edu.escuelaing.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.demo.model.Task;

public interface TaskRepository extends MongoRepository<Task,String>{
    Task findByname(String name);
    
}