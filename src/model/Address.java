package model;

public class Address {
    
    private long id;
    private long district_id;
    private long person_id;
    private String address;
    private String location;
    
    public Address() {
    }
    
    public Address(String address, String location, long district_id, long person_id) {
        this.address = address;
        this.location = location;
        this.district_id = district_id;
        this.person_id = person_id;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return person_id;
    }

    public void setPersonId(long person_id) {
        this.person_id = person_id;
    }

    public long getDistrictId() {
        return district_id;
    }

    public void setDistrictId(long district_id) {
        this.district_id = district_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
