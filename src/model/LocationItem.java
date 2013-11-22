package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="location_items")
public class LocationItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationItemId;

    @ManyToOne
    private Location location = new Location();

    @ManyToOne
    private Media media = new Media();

    public Long getLocationItemId() {
        return locationItemId;
    }

    public void setLocationItemId(Long locationItemId) {
        this.locationItemId = locationItemId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
