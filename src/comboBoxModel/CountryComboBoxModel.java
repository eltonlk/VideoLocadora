package comboBoxModel;

import dao.CountryDao;
import java.util.List;

public class CountryComboBoxModel extends util.GenericComboBoxModel {
    
    private CountryDao dao;
    
    public CountryComboBoxModel() {
        this.dao = new CountryDao();
        
        this.items = (List) dao.list();
    }
    
}