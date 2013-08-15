package model;

import java.util.Date;

public class Location {
    
    private long id;
    private long customer_id;
    private long employee_id;
    private String status;
    private Date booked_at;
    private Date removed_at;
    private Date returned_at;
    private double amount;
        
    public Location() {
    }
    
    public Location(long customer_id, long employee_id, String status, Date booked_at, Date removed_at, Date returned_at, double amount) {
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.status = status;
        this.booked_at = booked_at;
        this.removed_at = removed_at;
        this.returned_at = returned_at;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBooked_at() {
        return booked_at;
    }

    public void setBooked_at(Date booked_at) {
        this.booked_at = booked_at;
    }

    public Date getRemoved_at() {
        return removed_at;
    }

    public void setRemoved_at(Date removed_at) {
        this.removed_at = removed_at;
    }

    public Date getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(Date returned_at) {
        this.returned_at = returned_at;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
