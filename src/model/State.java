package model;

import framework.BaseModel;

public class State extends BaseModel {
    
    private String name;
    private String uf;
    private String country;
    
    public State() {
    }

    public State(String name, String uf, String country) {
        this.name = name;
        this.uf = uf;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
        final State other = (State) obj;
        return this.id == other.id;
    }     
    
    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do estado não pode ficar em branco.");
        } 
    }
}
