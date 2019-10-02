package edu.escuelaing.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data

public class User {
    private String id;
    private String name;
    private String description;
    private String password;

    public User(String id, String name, String description, String password) {
        this.id=id;
        this.description=description;
        this.name=name;
        this.password=password;
	}

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}