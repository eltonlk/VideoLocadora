package view.person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Address;
import model.Person;

import service.PersonService;

public class PersonActionListener implements ActionListener {

    private PersonFrm frm;
    private PersonService service;

    public PersonActionListener(PersonFrm frm) {
        this.frm = frm;
        service = new PersonService();
        attachListener();
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
        frm.getjBAdd().addActionListener(this);
        frm.getjBEdit().addActionListener(this);
        frm.getjBDestroy().addActionListener(this);
        frm.getjBSave().addActionListener(this);
        frm.getjBCancel().addActionListener(this);
    }
    
    private void enableButtonsToSave() {
        enableOrDisableButtonsToSave(true);
    }
    
    private void disableButtonsToSave() {
        enableOrDisableButtonsToSave(false);
    }
    
    private void enableOrDisableButtonsToSave(boolean enabled) {
        frm.getjBAdd().setEnabled(!enabled);
        frm.getjBEdit().setEnabled(!enabled);
        frm.getjBDestroy().setEnabled(!enabled);
        frm.getjBSave().setEnabled(enabled);
        frm.getjBCancel().setEnabled(enabled);
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
}
