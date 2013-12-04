package controller;

import dao.ActorDao;
import javax.swing.JDesktopPane;
import model.Actor;
import view.actors.*;

public class ActorController extends util.GenericController<Actor> {

    private ActorsInternalFrame listFrame;

    public ActorController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new ActorDao();
    }

    @Override
    public void list() {
        this.listFrame = new ActorsInternalFrame(this);

        showFrame(listFrame);
    }

}
