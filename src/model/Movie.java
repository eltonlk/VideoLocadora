package model;

import java.io.Serializable;
import java.util.Set;

public class Movie implements Serializable {

    private Long movieId;
    private String title;
    private String synopsis;
    private Set actors;
    private Set medias;

    public Movie() {
    }

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

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public void setMedias(Set<Media> medias) {
        this.medias = medias;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

}
