package edu.escuelaing.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class TaskList {
    String id;
    String name;
    List<Task> tasks;

}
