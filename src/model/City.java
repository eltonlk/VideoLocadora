package model;

import dao.CityDao;

public class City {
    
    private int id;
    private String name;
    private String zip;
    
    private State state;
    
    public City() {
    }

    public City(String name, String zip, State state) {
        this.name = name;
        this.zip = zip;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
    
    public City save() {
        new CityDao().insert(this);
        
        return this;
    }
}
