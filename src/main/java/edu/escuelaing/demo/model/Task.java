package edu.escuelaing.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
public class Task {
    @Id
    private String name;
    private String id;
    private String description;
    private String updateDate;
    private String isDone;
    private String dueDate;
    private String fileUrl;

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Task() {
    }

    public Task(String name,String id,String description,String updateDate,String isDone,String dueDate) {
        this.name=name;
        this.id=id;
        this.description=description;
        this.updateDate=updateDate;
        this.isDone=isDone;
        this.dueDate=dueDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsDone() {
        return this.isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
