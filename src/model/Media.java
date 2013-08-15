package model;

import java.util.Date;

public class Media {
    
    private long id;
    private long movie_id;
    private long supplier_id;
    private String kind;
    private double amount;
    private String status;
    private Date purchased_at;
       
    public Media() {
    }
    
    public Media(long movie_id, long supplier_id, String kind, double amount, String status, Date purchased_at) {
        this.movie_id = movie_id;
        this.supplier_id = supplier_id;
        this.kind = kind;
        this.amount = amount;
        this.status = status;
        this.purchased_at = purchased_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPurchased_at() {
        return purchased_at;
    }

    public void setPurchased_at(Date purchased_at) {
        this.purchased_at = purchased_at;
    }
    
}
