package util;

import javax.swing.JButton;

public abstract class GenericInternalFrame<C, M, TM> extends javax.swing.JInternalFrame {
    
    protected C controller;
    protected TM listTableModel;
    protected M object;
    protected GenericActionListener listener;
    
    protected abstract void enableOrDisableFields(boolean enable);

    protected abstract void setNewObject();    
    
    protected abstract void mappingObjectToForm();
    
    protected abstract void mappingFormToObject();
    
    protected void loadResources() {
        enableOrDisableFields(false);        
    }

    public C getController() {
        return controller;
    }
    
    public TM getListTableModel() {
        return listTableModel;
    }

    public M getObject() {
        return object;
    }
    
    public void setObject(M object) {
        this.object = object;
    }

    public abstract JButton getAddButton();

    public abstract JButton getDestroyButton();

    public abstract JButton getEditButton();

    public abstract JButton getFormSubmit();
    
}
