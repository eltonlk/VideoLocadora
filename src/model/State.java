package model;

import dao.StateDao;

public class State {
    
    private int id;
    private String name;
    
    private Country country;
    
    public State() {
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public State save() {
        new StateDao().insert(this);
        
        return this;
    }
    
}
