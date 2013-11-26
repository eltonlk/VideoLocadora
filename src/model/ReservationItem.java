package model;

import java.io.Serializable;

public class ReservationItem implements Serializable {

    private Long reservationItemId;
    private Reservation reservation;
    private Media media;

    public ReservationItem() {
    }
    
    public Long getReservationItemId() {
        return reservationItemId;
    }

    public void setReservationItemId(Long reservationItemId) {
        this.reservationItemId = reservationItemId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
