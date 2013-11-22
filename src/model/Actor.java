package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="actors")
public class Actor implements java.io.Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    
    @Column(name="name", nullable = false, unique = true, columnDefinition = "VARCHAR(100)", length = 100)
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Movie> movies =	new HashSet<>(0);    
    
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
