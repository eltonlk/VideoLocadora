package model;

import java.util.Date;

public class Media {
    
    private int id;
    private int movie_id;
    private int supplier_id;
    private String kind;
    private double amount;
    private String status;
    private Date purchased_at;
       
    public Media() {
    }
    
    public Media(int movie_id, int supplier_id, String kind, double amount, String status, Date purchased_at) {
        this.movie_id = movie_id;
        this.supplier_id = supplier_id;
        this.kind = kind;
        this.amount = amount;
        this.status = status;
        this.purchased_at = purchased_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movie_id;
    }

    public void setMovieId(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getSupplierId() {
        return supplier_id;
    }

    public void setSupplierId(int supplier_id) {
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

    public Date getPurchasedAt() {
        return purchased_at;
    }

    public void setPurchasedAt(Date purchased_at) {
        this.purchased_at = purchased_at;
    }
    
}
