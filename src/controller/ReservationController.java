package controller;

import javax.swing.JDesktopPane;
import view.reservations.*;

public class ReservationController extends util.GenericController<model.Reservation> {

    public ReservationController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void newReservation() {
        ReservationInternalFrame frame = new ReservationInternalFrame(this);

        showFrame(frame);
    }
}
