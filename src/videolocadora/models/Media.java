package videolocadora.models;

import java.util.Date;

public class Media {
    
    private int idMedia;
    private Movie movie;
    private Supplier supplier;
    private MediaKind kind;
    private Date purchaseAt;
    private String state;

    public Media() {
        this.kind = MediaKind.DVD;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public MediaKind getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getPurchaseAt() {
        return purchaseAt;
    }

    public void setPurchaseAt(Date purchaseAt) {
        this.purchaseAt = purchaseAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
