package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation_items")
public class ReservationItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationItemId;

    @ManyToOne
    private Reservation reservation = new Reservation();

    @ManyToOne
    private Media media = new Media();

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
