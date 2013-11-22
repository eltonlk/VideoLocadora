package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    private String synopsis;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Actor> cast = new HashSet<>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")   
    private Set<Media> medias = new HashSet<>(0);

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public void setMedias(Set<Media> medias) {
        this.medias = medias;
    }

    public void addActor(Actor actor) {
        this.cast.add(actor);
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

}
