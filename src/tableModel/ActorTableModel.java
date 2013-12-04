package tableModel;

import dao.ActorDao;
import java.util.ArrayList;
import java.util.List;
import model.Actor;

public class ActorTableModel extends util.GenericTableModel<Actor> {

    private ActorDao dao = new ActorDao();
    
    public ActorTableModel() {
        this.columns = new String[] { "Nome", "Sexo", "País" };
        
        reload();
    }

    public ActorTableModel(List<Actor> rows) {
	this.rows = new ArrayList<>(rows);
    }    
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return String.class;
        case 1:
            return String.class;
        case 2:
            return String.class;            
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actor actor = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return actor.getName();
        case 1: 
            return actor.getGender();
        case 2: 
            if (actor.getCountry() == null) return null;
            
            return actor.getCountry().getName();   
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {};

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public final void reload() {
        addItems(dao.list());
    }
    
}