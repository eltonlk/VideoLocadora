package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class GenericComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    protected List items;
    private Object selected;
    
    public GenericComboBoxModel() {
        this.items = new ArrayList<>(0);
    }
    
    @Override
    public Object getElementAt(int index) {
        return items.get(index);
    }	

    @Override
    public int getSize() {
        return items.size();
    }
		
    @Override
    public void setSelectedItem(Object item) {				
        this.selected = item;						
    }
		
    @Override
    public Object getSelectedItem(){
        if (selected == null && items.size() > 0) {
            this.selected = items.get(0);
        } 
        
        return selected;
    }	
		
    public void addAll(List items) {
        this.items.clear();
	
        setSelectedItem(null);
			
        for(Object item : items){
            this.items.add(item);

            fireIntervalAdded(item, 0, 0);
        }

    }
}
