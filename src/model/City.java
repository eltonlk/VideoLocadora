package model;

import framework.BaseModel;

public class City extends BaseModel {
    
    private String name;
    private State state;
    
    public City() {
    }

    public City(String name, State state) {
        this.name = name;
        this.state = state;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        return this.id == other.id;
    }    
    
    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome da cidade não pode ficar em branco.");
        }
    }
}
