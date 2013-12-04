package controller;

import dao.PersonDao;
import javax.swing.JDesktopPane;
import model.Person;
import view.people.*;

public class PersonController extends util.GenericController<Person> {

    private PeopleInternalFrame listFrame;

    public PersonController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new PersonDao();
    }

    @Override
    public void list() {
        this.listFrame = new PeopleInternalFrame(this);

        showFrame(listFrame);
    }

}
