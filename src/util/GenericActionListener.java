package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GenericActionListener implements ListSelectionListener, ActionListener {

    protected GenericInternalFrame frame;
    protected JTable table;
    protected GenericTableModel tableModel;
    protected GenericController controller;
    
    public GenericActionListener(GenericInternalFrame frame, JTable table, GenericTableModel tableModel, GenericController controller) {
        this.frame = frame;
        this.table = table;
        this.tableModel = tableModel;      
        this.controller = controller;
        
        load();
    }
    
    private void load() {
        table.getSelectionModel().addListSelectionListener(this);
        
        frame.getAddButton().addActionListener(this);
        frame.getEditButton().addActionListener(this);
        frame.getDestroyButton().addActionListener(this);
        frame.getFormSubmit().addActionListener(this);   
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (table.getSelectedRow() >= 0) {
            frame.enableOrDisableFields(false);
            
            frame.setObject((GenericModel) tableModel.getItem(table.getSelectedRow()));

            frame.mappingObjectToForm();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                add();
                break;
            case "edit":
                edit();
                break;
            case "destroy":
                destroy();
                break;
            case "save":
                save();
                break;
        }
    }
    
    private void add() {
        frame.setNewObject();
        
        frame.mappingObjectToForm();
        
        frame.enableOrDisableFields(true);
    }
    
    private void edit() {
        if (table.getSelectedRow() >= 0) {
            frame.enableOrDisableFields(true);
        } else {
            Message.editNotSelected();
        }        
    }
    
    private void destroy() {
        if (table.getSelectedRow() >= 0 && Message.confirmDestroy()) {
            controller.destroy(frame.getObject());
            
            frame.setNewObject();
            
            frame.mappingObjectToForm();
            
            tableModel.reload();
            
            frame.enableOrDisableFields(false);
            
            Message.destroyInfo();
        } else {
            Message.destroyNotSelected();
        }
    }
    
    private void save() {
        frame.mappingFormToObject();
        
        GenericModel object = (GenericModel) frame.getObject();
        
        if (controller.save(object)) {
            tableModel.reload();
            
            frame.enableOrDisableFields(false);
        }
        
        Message.form(frame, object);
    }    
    
}
