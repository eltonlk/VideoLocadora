package model;

public class State {
    
    private long id;
    private long country_id;
    private String name;
    
    public State() {
    }

    public State(String name, long country_id) {
        this.name = name;
        this.country_id = country_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCountryId() {
        return country_id;
    }

    public void setCountryId(long country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
