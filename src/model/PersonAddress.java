package model;

import framework.BaseModel;

public class PersonAddress extends BaseModel {
    
    private Person person;
    private String address;
    private String district;
    private String zip;
    private City city;
    
    public PersonAddress() {
    }
    
    public PersonAddress(String address, String district, String zip, City city) {
        this.address = address;
        this.district = district;
        this.zip = zip;
        this.city = city;
    }    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        final PersonAddress other = (PersonAddress) obj;
        return this.id == other.id;
    }    
    
    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(address)) {
            addError("address", "Endereço não pode ficar em branco.");
        }        
    }
}
