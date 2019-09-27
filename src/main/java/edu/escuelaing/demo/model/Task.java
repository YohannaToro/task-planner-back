package edu.escuelaing.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private String id;
    private String description;
    private String updateDate;
    private boolean isDone;
    private String dueDate;
}
