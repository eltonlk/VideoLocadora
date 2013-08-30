package view.person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import model.Address;
import model.Person;

import service.PersonService;

public class PersonActionListener implements ActionListener, ListSelectionListener {

    private PersonInternalFrame frame;
    private PersonService service;
    private PersonTableModel tableModel;

    PersonActionListener(PersonInternalFrame frame) {
        this.frame = frame;
        
        service = new PersonService();
        
        attachListener();
        
        loadTBPeople();
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

    private void attachListener() {
    }
    
    private void enableButtonsToSave() {
        enableOrDisableButtonsToSave(true);
    }
    
    private void disableButtonsToSave() {
        enableOrDisableButtonsToSave(false);
    }
    
    private void enableOrDisableButtonsToSave(boolean enabled) {
//        frm.getjBAdd().setEnabled(!enabled);
//        frm.getjBEdit().setEnabled(!enabled);
//        frm.getjBDestroy().setEnabled(!enabled);
//        frm.getjBSave().setEnabled(enabled);
//        frm.getjBCancel().setEnabled(enabled);
    }    
    
    private void add() {
        enableButtonsToSave();
    }
    
    private void edit() {
        enableButtonsToSave();
    }
    
    private void destroy() {
    }
    
    private void save() {
        service.save( mappingFormToPerson() );
        
        JOptionPane.showMessageDialog(frame, "Pessoa salva.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        disableButtonsToSave();      
    }
    
    private void cancel() {
        
    }
    
    private Person mappingFormToPerson() {
        Person person = new Person();
        
        if ( !"".equals( frame.getFormPanel().getLabelId().getText() ) ) {
            person.setId( Integer.parseInt(frame.getFormPanel().getLabelId().getText()) );
        }
        
        person.setName( frame.getFormPanel().getInputName().getText() );
        person.setLegalName( frame.getFormPanel().getInputLegalName().getText() );
        person.setDocument1( frame.getFormPanel().getInputDocument1().getText() );
        person.setDocument2( frame.getFormPanel().getInputDocument2().getText() );
        person.setEmail( frame.getFormPanel().getInputEmail().getText() );
        person.setKind( "customer" );
        person.setCel( frame.getFormPanel().getInputCel().getText() );
        person.setPhone( frame.getFormPanel().getInputPhone().getText() );
//        person.setStatus(frame.getjCBStatus());
        
//        person.setAddress( mappingFormToAddress() );
        
        return person;
    }
    
//    private Address mappingFormToAddress() {
//        Address address = new Address();
//        
//        if ( !"".equals( frame.getjLAddressId().getText() ) ) {
//            address.setId( Integer.parseInt(frame.getjLAddressId().getText()) );
//        }        
//        
//        address.setAddress( frame.getjTFAddress().getText() );
////        address.setDistrictId( );
//        address.setLocation( "work" );
//        
//        return address;        
//    }
    
    private void loadTBPeople() {
        tableModel = new PersonTableModel(service.getPeople());
        
        frame.getListPanel()
                .getTablePeople()
                .setModel(tableModel);
        
        frame.getListPanel()
                .getTablePeople()
                .getSelectionModel()
                .addListSelectionListener( this );
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Person person = tableModel.getPeople().get( frame.getListPanel().getTablePeople().getSelectedRow() );
        
        mappingPersonToForm(person);
    }
    
    private void mappingPersonToForm(Person person) {
        frame.getFormPanel().getLabelId().setText( Integer.toString(person.getId()) );
        frame.getFormPanel().getInputLegalName().setText( person.getLegalName() );
        frame.getFormPanel().getInputName().setText( person.getName() );
        frame.getFormPanel().getInputDocument1().setText( person.getDocument1() );
        frame.getFormPanel().getInputDocument2().setText( person.getDocument2() );
        frame.getFormPanel().getInputEmail().setText( person.getEmail() );
        frame.getFormPanel().getInputPhone().setText( person.getPhone() );
        frame.getFormPanel().getInputCel().setText( person.getCel() );
    }
    
}
