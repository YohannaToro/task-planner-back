package edu.escuelaing.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Board {
    String id;
    String name;
    List<TaskList> cards;

}

