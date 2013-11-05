package model;

import framework.BaseModel;

public class Genre extends BaseModel {
    
    private String name;
    private String status;
    
    public Genre() {
        this.status = "Ativo";
    }

    public Genre(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        final Genre other = (Genre) obj;
        return this.id == other.id;
    }

    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do genero não pode ficar em branco.");
        }
    }
    
}
