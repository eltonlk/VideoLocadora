package comboBoxModel;

import dao.StateDao;
import java.util.List;

public class StateComboBoxModel extends util.GenericComboBoxModel {
    
    private StateDao dao;
    
    public StateComboBoxModel() {
        this.dao = new StateDao();
        
        this.items = (List) dao.list();
    }
    
}