package model;

public class District {
    
    private long id;
    private long city_id;
    private String name;
    
    public District() {
    }
    
    public District(String name, long city_id) {
        this.name = name;
        this.city_id = city_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
