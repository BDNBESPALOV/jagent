package bdn.rest_projeckt.jagent.model;

import java.util.Date;

public class Tasks {
    private int id;
    private String task;
    private String taskStatus;
    private Date date;
    public Tasks(){}

    public Tasks(int id, String task,String taskStatus,  Date date) {
        this.id = id;
        this.task = task;
        this.date = date;
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
