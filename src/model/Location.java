package model;

public class Location {
    
    private int id;
    private int customer_id;
    private int employee_id;
    private String status;
    private String booked_at;
    private String removed_at;
    private String returned_at;
    private double amount;
        
    public Location() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBooked_at() {
        return booked_at;
    }

    public void setBooked_at(String booked_at) {
        this.booked_at = booked_at;
    }

    public String getRemoved_at() {
        return removed_at;
    }

    public void setRemoved_at(String removed_at) {
        this.removed_at = removed_at;
    }

    public String getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(String returned_at) {
        this.returned_at = returned_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
