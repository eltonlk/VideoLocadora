package view.person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Address;
import model.Person;

import service.PersonService;

public class PersonActionListener implements ActionListener, ListSelectionListener {

    private PersonFrm frm;
    private PersonService service;
    private PersonTableModel tableModel;

    public PersonActionListener(PersonFrm frm) {
        this.frm = frm;
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
        
        JOptionPane.showMessageDialog(frm, "Pessoa salva.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        disableButtonsToSave();      
    }
    
    private void cancel() {
        
    }
    
    private Person mappingFormToPerson() {
        Person person = new Person();
        
        if ( !"".equals( frm.getjLId().getText() ) ) {
            person.setId( Integer.parseInt(frm.getjLId().getText()) );
        }
        
        person.setName( frm.getjTFName().getText() );
        person.setLegalName( frm.getjTFLegalName().getText() );
        person.setDocument1( frm.getjTFDocument1().getText() );
        person.setDocument2( frm.getjTFDocument2().getText() );
        person.setEmail( frm.getjTFEmail().getText() );
        person.setKind( "customer" );
        person.setCel( frm.getjTFCel().getText() );
        person.setPhone( frm.getjTFPhone().getText() );
//        person.setStatus(frm.getjCBStatus());
        
//        person.setAddress( mappingFormToAddress() );
        
        return person;
    }
    
    private Address mappingFormToAddress() {
        Address address = new Address();
        
        if ( !"".equals( frm.getjLAddressId().getText() ) ) {
            address.setId( Integer.parseInt(frm.getjLAddressId().getText()) );
        }        
        
        address.setAddress( frm.getjTFAddress().getText() );
//        address.setDistrictId( );
        address.setLocation( "work" );
        
        return address;        
    }
    
    private void loadTBPeople() {
        tableModel = new PersonTableModel(service.getPeople());
        
        frm.getjTPeople().setModel(tableModel);
        
        frm.getjTPeople()
            .getSelectionModel()
            .addListSelectionListener( this );
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Person person = tableModel.getPeople().get( frm.getjTPeople().getSelectedRow() );
        
        mappingPersonToForm(person);
    }
    
    private Person mappingPersonToForm(Person person) {
        frm.getjLId().setText( Integer.toString(person.getId()) );
        frm.getjTFName().setText( person.getName() );
        frm.getjTFLegalName().setText( person.getLegalName() );
        frm.getjTFDocument1().setText( person.getDocument1() );
        frm.getjTFDocument2().setText( person.getDocument2() );
        frm.getjTFEmail().setText( person.getEmail() );
        frm.getjTFCel().setText( person.getCel() );
        frm.getjTFPhone().setText( person.getPhone() );
        
        return person;
    }
    
}
