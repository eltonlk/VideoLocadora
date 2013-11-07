package model;

import java.math.BigDecimal;
import java.util.Date;

public class Media {
    
    private int id;
    private Movie movie;
    private Person supplier;
    private String kind;
    private BigDecimal amount;
    private String status;
    private Date purchased_at;
    private BigDecimal amount_paid;
       
    public Media() {
    }
    
    public Media(Movie movie, Person supplier, String kind, BigDecimal amount, String status, Date purchased_at) {
        this.movie = movie;
        this.supplier = supplier;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getSupplier() {
        return supplier;
    }

    public void setSupplier(Person supplier) {
        this.supplier = supplier;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public BigDecimal getAmountPaid() {
        return amount_paid;
    }

    public void setAmountPaid(BigDecimal amount_paid) {
        this.amount_paid = amount_paid;
    }
    
}
