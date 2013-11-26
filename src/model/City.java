package model;

import java.io.Serializable;

public class City implements Serializable {

    private Long cityId;
    private String name;
    private State state;

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

}
