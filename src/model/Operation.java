package model;

import java.util.Date;

public class Operation {
    
    private int id;
    private boolean flow_in;
    private int person_id;
    private String description;
    private Date due_at;
    private double amount;
    private boolean paid;
    private Date paid_at;
    
    public Operation() {
    }
    
    public Operation(boolean flow_in, int person_id, String description, Date due_at, double amount, boolean paid, Date paid_at) {
        this.flow_in = flow_in;
        this.person_id = person_id;
        this.description = description;
        this.due_at = due_at;
        this.amount = amount;
        this.paid = paid;
        this.paid_at = paid_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlowIn() {
        return flow_in;
    }

    public void setFlowIn(boolean flow_in) {
        this.flow_in = flow_in;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int person_id) {
        this.person_id = person_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueAt() {
        return due_at;
    }

    public void setDueAt(Date due_at) {
        this.due_at = due_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getPaidAt() {
        return paid_at;
    }

    public void setPaidAt(Date paid_at) {
        this.paid_at = paid_at;
    }
    
}
