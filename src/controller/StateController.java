package controller;

import dao.StateDao;
import javax.swing.JDesktopPane;
import model.State;
import view.states.*;

public class StateController extends util.GenericController<State> {

    private StatesInternalFrame listFrame;

    public StateController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new StateDao();
    }

    @Override
    public void list() {
        this.listFrame = new StatesInternalFrame(this);

        showFrame(listFrame);
    }

}
