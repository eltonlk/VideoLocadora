package framework;

public abstract class BaseModel extends ModelValidation {

    protected int id;    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
}
