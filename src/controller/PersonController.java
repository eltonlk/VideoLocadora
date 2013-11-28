package controller;

import javax.swing.JDesktopPane;
import view.people.*;

public class PersonController extends util.GenericController<model.Person> {

    public PersonController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        PeopleInternalFrame frame = new PeopleInternalFrame();
        
        showFrame(frame);
    }
   
}
