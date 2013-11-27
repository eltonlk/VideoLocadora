package model;

import java.io.Serializable;
import java.util.Currency;

public class Media implements Serializable {

    private Long mediaId;
    private String kind;
    private Currency amount;
    private Movie movie;

    public Media() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
