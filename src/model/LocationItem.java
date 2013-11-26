package model;

import java.io.Serializable;

public class LocationItem implements Serializable {

    private Long locationItemId;
    private Location location;
    private Media media;

    public LocationItem() {
    }
    
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
