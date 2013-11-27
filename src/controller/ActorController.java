package controller;

import dao.ActorDao;
import javax.swing.JDesktopPane;
import view.actors.*;

public class ActorController extends util.GenericController<model.Actor> {
    
    private ActorDao dao = new ActorDao();
    
    public ActorController(JDesktopPane pane) {
        this.pane = pane;
    }

    @Override
    public void list() {
        ActorsInternalFrame frame = new ActorsInternalFrame();
        
        showFrame(frame);
    }
    
}
