package model;

import dao.CountryDao;

public class Country extends util.GenericModel {

    private Long countryId;
    private String name;
    private String nationality;
    private String acronym;

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do país não pode ficar em branco.");
        } else {
            CountryDao dao = new CountryDao();

            if (dao.exists(this)) {
                addError("name", "País já existe.");
            }
        }
    }

}
