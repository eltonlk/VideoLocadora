package model;

import framework.BaseModel;

public class User extends BaseModel {
    
    private Person person;
    private String login;
    private String password;
    private String email;
    
    public User() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
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
        final User other = (User) obj;
        return this.id == other.id;
    }      
    
    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(login)) {
            addError("login", "Login do usúario não pode ficar em branco.");
        } 
        if (ValidationUtils.isEmpty(password)) {
            addError("password", "Senha do usúario não pode ficar em branco.");
        }
        if (ValidationUtils.isEmpty(email)) {
            addError("email", "Email do usúario não pode ficar em branco.");
        } 
    }
    
}
