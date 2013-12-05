package comboBoxModel;

import dao.CityDao;
import java.util.List;

public class CityComboBoxModel extends util.GenericComboBoxModel {
    
    private CityDao dao;
    
    public CityComboBoxModel() {
        this.dao = new CityDao();
        
        this.items = (List) dao.list();
    }
    
}