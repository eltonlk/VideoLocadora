package model;

import dao.ActorDao;
import java.util.Set;

public class Actor extends util.GenericModel {

    private Long actorId;
    private byte[] avatar;
    private String name;
    private String gender;
    private Country country;
    private Set<Movie> movies;

    public Actor() {
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do país não pode ficar em branco.");
        } else {
            ActorDao dao = new ActorDao();

            if (dao.exists(this)) {
                addError("name", "Ator já existe.");
            }
        }
    }

}
