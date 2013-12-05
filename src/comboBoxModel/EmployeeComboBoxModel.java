package comboBoxModel;

import dao.PersonDao;
import java.util.List;

public class EmployeeComboBoxModel extends util.GenericComboBoxModel {
    
    private PersonDao dao;
    
    public EmployeeComboBoxModel() {
        this.dao = new PersonDao();
        
        this.items = (List) dao.list("employee");
    }
    
}