package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="actors")
public class Actor {
    
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    
    @Column(name="nome", nullable = false, unique = true, columnDefinition = "VARCHAR(60)", length = 60)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
