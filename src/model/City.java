package model;

import dao.CityDao;

public class City extends util.GenericModel {

    private Long cityId;
    private String name;
    private State state;
    private String zip;

    public City() {
    }
    
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    @Override
    protected void validateRules() {
        if (state == null) {
            addError("state", "Estado não pode ficar em branco.");
        }
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome da cidade não pode ficar em branco.");
        } else {
            CityDao dao = new CityDao();

            if (dao.exists(this)) {
                addError("name", "Nome da cidade já existe para este estado.");
            }
        }
    }
    
}
