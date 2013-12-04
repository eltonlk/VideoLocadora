package controller;

import dao.CityDao;
import javax.swing.JDesktopPane;
import model.City;
import view.cities.*;

public class CityController extends util.GenericController<City> {

    private CitiesInternalFrame listFrame;

    public CityController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new CityDao();
    }

    @Override
    public void list() {
        this.listFrame = new CitiesInternalFrame(this);

        showFrame(listFrame);
    }

}
