package model;

import dao.ActorDao;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ActorComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private final ActorDao dao = new ActorDao();
    private final List<Actor> actors;  
    private Actor actor;  
      
    public ActorComboBoxModel() {
        this.actors = dao.getAll();
    }
    
    @Override  
    public void setSelectedItem(Object o) {  
        this.actor = (Actor) o;  
    }  
  
    @Override  
    public Object getSelectedItem() {  
        return actor;  
    }  
  
    @Override  
    public int getSize() {  
        return actors.size();  
    }  
  
    @Override  
    public Object getElementAt(int i) {  
        return actors.get(i);  
    }  
    
}
