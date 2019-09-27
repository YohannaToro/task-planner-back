package edu.escuelaing.demo.repository.impl;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.TaskList;
import edu.escuelaing.demo.repository.TaskPlannerPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskPlannerPersistenceImpl implements TaskPlannerPersistence {
    ConcurrentHashMap<String, Board> boards= new ConcurrentHashMap<>();
    public TaskPlannerPersistenceImpl(){

        String updtaeDate = "2018-12-18 15:30";
        String dueDate1 = "2018";
        List<TaskList> functions= new ArrayList<>();List<Task> tasks=new ArrayList<>();List<Task> tasks2=new ArrayList<>();
        Task t=new Task("hacer ...","1",null,updtaeDate,false,dueDate1);
        Task t1=new Task("hacer ...","2",null,updtaeDate,false,dueDate1);
        Task t2=new Task("hacer ...","3",null,updtaeDate,false,dueDate1);
        Task t3=new Task("hacer ...","4",null,updtaeDate,false,dueDate1);
        tasks.add(t1);tasks.add(t2);tasks2.add(t1);tasks.add(t3);tasks.add(t2);
        TaskList funct1 = new TaskList("1","prueba",tasks);
        TaskList funct2 = new TaskList("2","prueba1",tasks2);
        TaskList funct3 = new TaskList("3","prueba2",tasks);
        TaskList funct4 = new TaskList("4","prueba3",tasks2);
        functions.add(funct3);
        functions.add(funct4);
        functions.add(funct1);
        functions.add(funct2);
        Board b=new Board("1","iet",functions);
        Board b1=new Board("2","lab",functions);
        Board b2= new Board("3","proyect",functions);
        boards.put("1", b);
        boards.put("2", b1);
        boards.put("3", b2);
        System.out.println("jejeje que esta psando mk");



    }

    @Override
    public void saveTakeList(String boardId,TaskList taskList) {
        boards.get(boardId).getCards().add(taskList);
    }

    @Override
    public void updateList(String name, TaskList taskList) {

        for(TaskList tsl:boards.get(name).getCards()){
            if(tsl.getId().equals(taskList.getId())){
                tsl.setName(taskList.getName());
                tsl.setTasks(taskList.getTasks());
            }
        }


    }

    @Override
    public void addCard(String id, Task task,String idList) {
        List<TaskList> st=boards.get(id).getCards();
        for(TaskList ts: st){
            if(ts.getId().equals(idList)) {ts.getTasks().add(task);break;}
        }
    }

    @Override
    public List<TaskList> getAllTaskList(String id) {
        return boards.get(id).getCards();
    }

    @Override
    public void deleteList(String name,TaskList taskList) {
        boards.get(name).getCards().remove(taskList);

    }

    @Override
    public void updateTask(String id, Task task,String idList) {
        List<TaskList> tsL=boards.get(id).getCards();
        for(TaskList ts:tsL){
            if(ts.getId().equals(idList)){
                Task t=getTaskById(ts,task.getId());
                t.setDescription(task.getDescription());
                t.setName(task.getName());
                t.setDueDate(task.getDueDate());
                t.setDone(task.isDone());
                break;
            }
        }

    }



    @Override
    public Task getTask(String id,String idTask,String board) {
        for(TaskList ts: boards.get(board).getCards()){
            if(ts.getId().equals(id)){
                return getTaskById(ts,idTask);
            }

        }
        return null;
    }




    @Override
    public void updateBoard(String name, Board board) {

    }

    @Override
    public void saveBoard(Board board) {

    }

    @Override
    public void deleteBoard(Board board) {

    }

    @Override
    public List<Board> getAllBoards() {
        List<Board> br= new ArrayList<>();
        for(Board br1:boards.values()){
            br.add(br1);
        }

        return br;
    }

    @Override
    public Board getBoard(String id) {
        return null;
    }

    @Override
    public TaskList getTaskListById(String board, String id) {
        for(TaskList ts:boards.get(board).getCards()){
            if(ts.getId().equals(id)) return ts;
        }
        return null;
    }

    @Override
    public void deleteTaskById(String tsl,String id,String board) {
        for(TaskList ts: boards.get(board).getCards()){
            if(ts.getId().equals(tsl)){ts.getTasks().remove(getTaskById(ts,id)); break;}
        }

    }


    private Task getTaskById(TaskList tsL,String task){
        for(Task ts:tsL.getTasks()){

            if(ts.getId().equals(task)){
                return ts;
            }
        }
        return null;
    }
}
