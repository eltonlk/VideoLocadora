package model;

public class User {
    
    private long id;
    private long person_id;
    private String login;
    private String password;
    private String email;
    
    public User() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
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
    
}
