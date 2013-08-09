package model;

public class Operation {
    
    private int id;
    private boolean flow_in;
    private int person_id;
    private String description;
    private String due_at;
    private double amount;
    private boolean paid;
    private String paid_at;
    
    public Operation() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlow_in() {
        return flow_in;
    }

    public void setFlow_in(boolean flow_in) {
        this.flow_in = flow_in;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_at() {
        return due_at;
    }

    public void setDue_at(String due_at) {
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

    public String getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }
    
}
