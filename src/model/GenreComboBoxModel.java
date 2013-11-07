package model;

import dao.GenreDao;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class GenreComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private final GenreDao dao = new GenreDao();
    private final List<Genre> genres;  
    private Genre genre;  
      
    public GenreComboBoxModel() {
        genres = dao.getAll();
    }
    
    @Override  
    public void setSelectedItem(Object o) {  
        genre = (Genre)o;  
    }  
  
    @Override  
    public Object getSelectedItem() {  
        return genre;  
    }  
  
    @Override  
    public int getSize() {  
        return genres.size();  
    }  
  
    @Override  
    public Object getElementAt(int i) {  
        return genres.get(i);  
    }  

}
