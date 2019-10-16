package edu.escuelaing.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    String id;
    String name;
    List<TaskList> cards;

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

    public List<TaskList> getCards() {
        return this.cards;
    }

    public void setCards(List<TaskList> cards) {
        this.cards = cards;
    }

    public Board(String id,String name,List<TaskList> cards) {
        this.id=id;
        this.name=name;
        this.cards=cards;
    }

}

