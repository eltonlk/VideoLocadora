package controller;

import dao.ActorDao;
import javax.swing.JDesktopPane;
import view.actors.*;

public class ActorController extends util.GenericController<model.Actor> {
    
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
