package model;

import java.io.Serializable;

public class Genre implements Serializable {

    private Long genreId;
    private String name;

    public Genre() {
    }
    
    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
