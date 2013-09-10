package view.person;

import model.PersonTableModel;
import view.components.toolbar.BaseToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mapping.PersonMapping;
import model.Person;

import service.PersonService;

public class PersonActionListener implements ActionListener, ListSelectionListener {

    private BaseToolBar toolbar;
    private PersonInternalFrame frame;
    private PersonMapping mapping;
    private PersonService service;
    private PersonTableModel tableModel;
    private String kind;
    private JTable tablePeople;

    PersonActionListener(PersonInternalFrame frame, String kind) {
        this.frame = frame;
        this.kind = kind;
    }
   
    public void initComponents() {
        this.mapping = new PersonMapping( frame.getFormPanel() );
        
        this.service = new PersonService();
        
        this.toolbar = frame.getBaseToolBar();
        
        this.tablePeople = frame.getListPanel().getTablePeople();
        
        loadTBPeople();        
    }
    
    @Override
    public void valueChanged(ListSelectionEvent event) {
        Person person = tableModel.getPerson( frame.getListPanel().getTablePeople().getSelectedRow() );
        
        mapping.toForm(person);
    }    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
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
            case "cancel":
                cancel();
                break;
        }
    }
    
    private void loadTBPeople() {
        tableModel = new PersonTableModel(service.getByKind(kind));
        
        tablePeople.setModel(tableModel);
        
        tablePeople.getSelectionModel()
                .addListSelectionListener( this );
    }    
    
    private void add() {
        toolbar.enableButtonsToSave();
    }
    
    private void edit() {
        toolbar.enableButtonsToSave();
    }
    
    private void destroy() {
        Person person = mapping.toPerson();
                
        service.destroy(person);
        
        JOptionPane.showMessageDialog(frame, "Registro excluído.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        tableModel.removePerson(person);        
    }
    
    private void save() {
        Person person = mapping.toPerson();
        
        service.save(person);
        
        JOptionPane.showMessageDialog(frame, "Registro salvo.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        tableModel.addPerson(person);
        
        toolbar.disableButtonsToSave();      
    }
    
    private void cancel() {
        toolbar.disableButtonsToSave();
    }
    
}
