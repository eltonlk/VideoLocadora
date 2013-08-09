package model;

public class Media {
    
    private int id;
    private int movie_id;
    private int supplier_id;
    private String kind;
    private double amount;
    private String status;
    private String purchased_at;
       
    public Media() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
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

    public String getPurchased_at() {
        return purchased_at;
    }

    public void setPurchased_at(String purchased_at) {
        this.purchased_at = purchased_at;
    }
    
}
