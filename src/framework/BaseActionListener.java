package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BaseActionListener implements ActionListener, ListSelectionListener {

    private final JInternalFrame frame;
    private final JTable table;
    
    public BaseActionListener(JInternalFrame frame, JTable table) {
        this.frame = frame;
        this.table = table;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//    @Override
//    public void actionPerformed(ActionEvent event) {
//        switch (event.getActionCommand()) {
//            case "add":
//                add();
//                break;
//            case "edit":
//                edit();
//                break;
//            case "destroy":
//                destroy();
//                break;
//            case "save":
//                save();
//                break;
//            case "cancel":
//                cancel();
//                break;
//        }
//    }
//
//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void cancel() {
//        frame.getFormPanel().enableOrDisableFields(false);
//        
//        toolbar.disableButtonsToSave();
//    }
//    
//}
//
//import model.PersonTableModel;
//import view.components.toolbar.BaseToolBar;
//
//import mapping.PersonMapping;
//import model.Person;
//
//import service.PersonService;
//import view.components.message.BaseMessage;
//
//public class PersonActionListener 
//
//    private BaseToolBar toolbar;
//    private final PersonInternalFrame frame;
//    private PersonMapping mapping;
//    private PersonService service;
//    private PersonTableModel tableModel;
//    private final String kind;
//    
//
//
//   
//    public void initComponents() {
//        this.mapping = new PersonMapping( frame.getFormPanel() );
//        
//        this.service = new PersonService();
//        
//        this.toolbar = frame.getBaseToolBar();
//        
//        this.table = frame.getListPanel().getTable();
//        
//        loadTBPeople();        
//    }
//    
//    @Override
//    public void valueChanged(ListSelectionEvent event) {
//        Person person = tableModel.getPerson( table.getSelectedRow() );
//        
//        mapping.toForm(person);
//        
//        toolbar.disableButtonsToSave();
//    }    
//    
//    
//    
//    private void loadTBPeople() {
//        tableModel = new PersonTableModel(service.getByKind(kind));
//        
//        table.setModel(tableModel);
//        
//        table.getSelectionModel()
//                .addListSelectionListener( this );
//    }    
//    
//    private void add() {
//        mapping.toForm(new Person());
//        
//        frame.getFormPanel().enableOrDisableFields(true);
//        
//        toolbar.enableButtonsToSave();
//    }
//    
//    private void edit() {
//        frame.getFormPanel().enableOrDisableFields(true);
//        
//        toolbar.enableButtonsToSave();
//    }
//    
//    private void destroy() {
//        if (BaseMessage.confirmDestroy()) {
//            Person person = mapping.toPerson();
//
//            service.destroy(person);
//
//            tableModel.removePerson(person);        
//            
//            BaseMessage.destroyInfo();
//        }
//    }
//    
//    private void save() {
//        Person person = mapping.toPerson();
//        
//        if (service.save(person)) {
//            tableModel.addPerson(person);
//            
//            frame.getFormPanel().enableOrDisableFields(false);
//            
//            toolbar.disableButtonsToSave();      
//        }
//        
//        BaseMessage.form(frame, person);
//    }
//    
//}
