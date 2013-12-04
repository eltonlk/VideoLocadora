package comboBoxModel;

import dao.GenreDao;
import java.util.List;

public class GenreComboBoxModel extends util.GenericComboBoxModel {
    
    private GenreDao dao;
    
    public GenreComboBoxModel() {
        this(false);
    }
    
    public GenreComboBoxModel(boolean empty) {
        this.dao = new GenreDao();
        
        List daoItems = (List) dao.list();
        
        if (empty) {
            daoItems.add(0, "Todos");
        }
        
        this.items = daoItems;
    }
    
}
