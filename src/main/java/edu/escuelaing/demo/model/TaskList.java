package edu.escuelaing.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TaskList {
    String id;
    String name;
    List<Task> tasks;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(String name,String id,List<Task> tasks) {
        this.name=name;
        this.id=id;
        this.tasks=tasks;
    }

}
