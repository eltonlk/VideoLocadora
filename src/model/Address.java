package model;

public class Address {
    
    private int id;
    private int person_id;
    private String address;
    private String location;
    
    private District district;
    
    public Address() {
    }
    
    public Address(String address, String location, District district) {
        this.address = address;
        this.location = location;
        this.district = district;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int person_id) {
        this.person_id = person_id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrictId(District district) {
        this.district = district;
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
