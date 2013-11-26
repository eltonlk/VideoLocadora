package model;

import java.util.Set;

public class Actor implements java.io.Serializable {
    
    private Long actorId;
    private String name;
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
    
    public Set<Movie> getMovies() {
        return this.movies;
    }
    
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    
}
