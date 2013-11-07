package model;

import framework.BaseModel;
import java.util.Date;
import java.util.List;

public class Movie extends BaseModel {
    
    private String title;
    private Date release_in;
    private String synopsis;
    private Genre genre;
    
    private List<Media> medias;
    
    private List<Actor> actors;    
    
    public Movie() {
    }
    
    public Movie(String title, Date release_in, String synopsis, Genre genre) {
        this.title = title;
        this.release_in = release_in;
        this.synopsis = synopsis;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseIn() {
        return release_in;
    }

    public void setReleaseIn(Date release_in) {
        this.release_in = release_in;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        
        return this.id == other.id;
    }

    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(title)) {
            addError("title", "Título do filme não pode ficar em branco.");
        }
    }
}
