package view.person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import service.PersonService;

public class PersonActionListener implements ActionListener {

    private PersonFrm frm;
    private PersonService service;

    public PersonActionListener(PersonFrm frm) {
        this.frm = frm;
        service = new PersonService();
        attachListener();
    }
    
    private void attachListener() {
        frm.getjBNew().addActionListener(this);
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
        frm.getjBNew().setEnabled(!enabled);
        frm.getjBEdit().setEnabled(!enabled);
        frm.getjBDestroy().setEnabled(!enabled);
        frm.getjBSave().setEnabled(enabled);
        frm.getjBCancel().setEnabled(enabled);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
    }
    
}
