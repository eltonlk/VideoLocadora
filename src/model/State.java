package model;

import dao.StateDao;

public class State extends util.GenericModel {

    private Long stateId;
    private String name;
    private Country country;
    private String acronym;

    public State() {
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    protected void validateRules() {
        if (country == null) {
            addError("country", "País não pode ficar em branco.");
        }
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do estado não pode ficar em branco.");
        } else {
            StateDao dao = new StateDao();

            if (dao.exists(this)) {
                addError("name", "Estado já existe para este país.");
            }
        }
    }

}
