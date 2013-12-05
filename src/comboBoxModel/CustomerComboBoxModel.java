package comboBoxModel;

import dao.PersonDao;
import java.util.List;

public class CustomerComboBoxModel extends util.GenericComboBoxModel {
    
    private PersonDao dao;
    
    public CustomerComboBoxModel() {
        this.dao = new PersonDao();
        
        this.items = (List) dao.list("customer");
    }
    
}