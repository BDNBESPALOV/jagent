package bdn.rest_projeckt.jagent.model;


import java.util.Date;

public class Condition {
    private Date date;
    private boolean condition;
    private String name;

    public Condition(Date date, boolean condition, String name) {
        this.date = date;
        this.condition = condition;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
