package videolocadora.models;

public class MovieCast {
    
    private Movie movie;
    private Actor actor;

    public MovieCast() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

}
