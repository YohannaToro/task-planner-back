package edu.escuelaing.demo.controller;

import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.TaskList;
import edu.escuelaing.demo.service.TaskPlannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/boards")
@CrossOrigin
public class TaskController {
    @Autowired
    TaskPlannerService taskServices;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Board>> getAllBoards() {

        List<Board> data= taskServices.getAllBoards();
       // System.out.println(data.size());
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") String id){

        try {
            Board data=taskServices.getBoardbyId(id);
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{id}/{idTask}")
    public ResponseEntity<?> getTaskListbyId(@PathVariable("id") String id,@PathVariable("idTask") String idTask){

        try {
            TaskList data=taskServices.getTaskListById(id,idTask);
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
