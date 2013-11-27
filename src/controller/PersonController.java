package controller;

import javax.swing.JDesktopPane;

public class PersonController extends util.GenericController<model.Person> {

    public PersonController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
