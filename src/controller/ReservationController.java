package controller;

import javax.swing.JDesktopPane;
import tableModel.ReservationTableModel;

public class ReservationController extends util.GenericController<model.Reservation> {

    public ReservationController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.ReservationDao();
        this.tableModel = new ReservationTableModel();
    }    
   
}
