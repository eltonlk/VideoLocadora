package model;

import java.io.Serializable;

public class Country implements Serializable {

    private Long countryId;
    private String name;

    public Country() {
    }
   
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
