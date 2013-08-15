package model;

public class City {
    
    private long id;
    private long state_id;
    private String name;
    private String zip;
    
    public City() {
    }

    public City(String name, String zip, long state_id) {
        this.name = name;
        this.zip = zip;
        this.state_id = state_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getState_id() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id = state_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
