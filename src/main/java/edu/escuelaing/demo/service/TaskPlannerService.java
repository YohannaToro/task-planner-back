package edu.escuelaing.demo.service;

import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.TaskList;
import edu.escuelaing.demo.repository.TaskPlannerPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskPlannerService {
    @Autowired
    TaskPlannerPersistence taskListPersistence;
    public void saveList(String boardID, TaskList taskList){
        taskListPersistence.saveTakeList(boardID,taskList);

    }
    public void updateList(String name,TaskList taskList){
        taskListPersistence.updateList(name,taskList);
    }
    public void addCard(String name, Task task, String idList){
        taskListPersistence.addCard(name,task,idList);
    }
    public void deleteList(String name,TaskList taskList){
        taskListPersistence.deleteList(name,taskList);
    }
    public List<TaskList> getAllTaskList(String id){
        return taskListPersistence.getAllTaskList(id);

    }
    public void updateTask(String name, Task task,String id){
        taskListPersistence.updateTask(name,task,id);
    }
    public Task getTaskById(String id,String idT,String board){
        return taskListPersistence.getTask(id,idT,board);
    }
    public void deleteTask(String tsl,String id,String board){
        taskListPersistence.deleteTaskById(tsl,id,board);
    }
    public void updateBoard(String name, Board board){
        taskListPersistence.updateBoard(name,board);
    }
    public  void saveBoard(Board board){
        taskListPersistence.saveBoard(board);
    }
    public void deleteBoard(Board board){
        taskListPersistence.deleteBoard(board);
    }
    public List<Board> getAllBoards(){

        return taskListPersistence.getAllBoards();
    }
    public Board getBoardbyId(String id){
        return taskListPersistence.getBoard(id);

    }
    public TaskList getTaskListById(String board,String id){return taskListPersistence.getTaskListById(board,id);}

}
