package controller;

import javax.swing.JDesktopPane;
import view.states.*;

public class StateController extends util.GenericController<model.State> {

    public StateController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        StatesInternalFrame frame = new StatesInternalFrame();
        
        showFrame(frame);
    }
   
}
