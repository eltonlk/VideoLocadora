package model;

import java.io.Serializable;

import java.util.Set;

public class Location implements Serializable {

    private Long locationId;
    private Person person;
    private Set items;

    public Location() {
    }
    
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<LocationItem> getItems() {
        return items;
    }

    public void setItems(Set<LocationItem> items) {
        this.items = items;
    }

}
