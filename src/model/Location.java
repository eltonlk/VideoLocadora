package model;

import java.util.Currency;
import java.util.Date;

import java.util.Set;

public class Location extends util.GenericModel {

    private Long locationId;
    private Person customer;
    private Date leasedIn;
    private Currency amount;
    private Person employee;
    private Set<LocationItem> items;

    public Location() {
    }
    
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public Date getLeasedIn() {
        return leasedIn;
    }

    public void setLeasedIn(Date leasedIn) {
        this.leasedIn = leasedIn;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }

    public Person getEmployee() {
        return employee;
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
    }
    
    public Set<LocationItem> getItems() {
        return items;
    }

    public void setItems(Set<LocationItem> items) {
        this.items = items;
    }

    @Override
    protected void validateRules() {
        if (customer == null) {
            addError("customer", "Cliente não pode ficar em branco.");
        } 
        
        if (leasedIn == null) {
            addError("leased_in", "Data de locação não pode ficar em branco.");
        }
        
        if (employee == null) {
            addError("employee", "Colaborador não pode ficar em branco.");
        } 
    }

}
