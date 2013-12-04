package model;

import dao.GenreDao;

public class Genre extends util.GenericModel {

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

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome do genero não pode ficar em branco.");
        } else {
            GenreDao dao = new GenreDao();

            if (dao.exists(this)) {
                addError("name", "Genero já existe.");
            }
        }
    }

}
