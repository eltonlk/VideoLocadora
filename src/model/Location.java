package model;

import java.util.Date;

public class Location {
    
    private int id;
    private int customer_id;
    private int employee_id;
    private String status;
    private Date booked_at;
    private Date removed_at;
    private Date returned_at;
    private double amount;
        
    public Location() {
    }
    
    public Location(int customer_id, int employee_id, String status, Date booked_at, Date removed_at, Date returned_at, double amount) {
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.status = status;
        this.booked_at = booked_at;
        this.removed_at = removed_at;
        this.returned_at = returned_at;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBookedAt() {
        return booked_at;
    }

    public void setBookedAt(Date booked_at) {
        this.booked_at = booked_at;
    }

    public Date getRemovedAt() {
        return removed_at;
    }

    public void setRemovedAt(Date removed_at) {
        this.removed_at = removed_at;
    }

    public Date getReturnedAt() {
        return returned_at;
    }

    public void setReturnedAt(Date returned_at) {
        this.returned_at = returned_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
