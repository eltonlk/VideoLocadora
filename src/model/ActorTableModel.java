package model;

public class ActorTableModel extends framework.BaseTableModel {

    public void ActorTableModel() {
        setColumns(new String[][] { { "id", "Código" }, { "name", "Nome" } });
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actor actor = (Actor) items.get(rowIndex);

        switch (columnIndex) {
        case 0:
            return actor.getId();
        case 1:
            return actor.getName();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
}
