package model;

public class Movie {
    
    private int id;
    private String title;
    private int year;
    private String synopsis;
    private int gender_id;
    
    public Movie() {
    }
    
    public Movie(String title, int year, String synopsis, int gender_id) {
        this.title = title;
        this.year = year;
        this.synopsis = synopsis;
        this.gender_id = gender_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getGenderId() {
        return gender_id;
    }

    public void setGenderId(int gender_id) {
        this.gender_id = gender_id;
    }
    
}
