package model;

import java.io.Serializable;
import java.util.Set;

public class Reservation implements Serializable {

    private Long reservationId;
    private Person person;
    private Set<ReservationItem> items;

    public Reservation() {
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<ReservationItem> getItems() {
        return items;
    }

    public void setItems(Set<ReservationItem> items) {
        this.items = items;
    }

}
