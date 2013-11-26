package model;

import java.util.Date;
import java.util.Set;

public class Actor implements java.io.Serializable {
    
    private Long actorId;
    private String name;
    private String gender;
    private Date birth;
    private Country country;
    private Set movies;    
    
    public Actor() {
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    public Set getMovies() {
        return movies;
    }

    public void setMovies(Set movies) {
        this.movies = movies;
    }
    
}
