package controller;

import dao.PersonDao;
import javax.swing.JDesktopPane;
import model.Person;
import view.people.*;

public class PersonController extends util.GenericController<Person> {

    private PeopleInternalFrame listFrame;
    private String kind;

    public PersonController(JDesktopPane pane, String kind) {
        this.pane = pane;
        this.dao = new PersonDao();
        this.kind = kind;
    }

    @Override
    public void list() {
        this.listFrame = new PeopleInternalFrame(this);

        showFrame(listFrame);
    }

    public String getKind() {
        return kind;
    }

}
