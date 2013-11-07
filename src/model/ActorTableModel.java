package model;

public class ActorTableModel extends framework.BaseTableModel {

    public ActorTableModel() {
        this.columns = new String[]{ "Nome" };
    }    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actor actor = (Actor) items.get(rowIndex);

        switch (columnIndex) {
        case 0:
            return actor.getName();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
}
