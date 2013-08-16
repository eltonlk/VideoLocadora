package model;

import dao.DistrictDao;

public class District {
    
    private int id;
    private String name;

    private City city;
    
    public District() {
    }
    
    public District(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public District save() {
        new DistrictDao().insert(this);
        
        return this;
    }
    
}
