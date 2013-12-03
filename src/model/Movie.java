package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Movie implements Serializable {

    private Long movieId;
    private byte[] avatar;
    private String title;
    private String kind;
    private Date releasedIn;
    private Genre genre;
    private int duration;
    private String synopsis;
    private Set<Actor> actors;
    private Set<Media> medias;

    public Movie() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getReleasedIn() {
        return releasedIn;
    }

    public void setReleasedIn(Date releasedIn) {
        this.releasedIn = releasedIn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
