package edu.escuelaing.demo.repository;

import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.TaskList;


import java.util.List;

public interface TaskPlannerPersistence {
    void saveTakeList(String boardId, TaskList taskList);

    void updateList(String name, TaskList taskList);

    void addCard(String name, Task task, String idList);

    List<TaskList> getAllTaskList(String id);

    void deleteList(String name,TaskList taskList);

    void updateTask(String name, Task task,String id);

    Task getTask(String id,String task,String idBoard);

    void deleteTaskById(String tsl,String id,String board);


    void updateBoard(String name, Board board);

    void saveBoard(Board board);

    void deleteBoard(Board board);

    List<Board> getAllBoards();

    Board getBoard(String id);

    TaskList getTaskListById(String board, String id);
}
