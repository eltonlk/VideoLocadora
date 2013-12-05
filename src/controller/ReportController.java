package controller;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import view.reports.ListMoviesInternalFrame;
import view.reports.LocationsByPeriodInternalFrame;

public class ReportController {

    private JDesktopPane pane;
    
    public ReportController(JDesktopPane pane) {
        this.pane = pane;
    }    
    
    public void locationsByPeriod() {
        LocationsByPeriodInternalFrame frame = new LocationsByPeriodInternalFrame();
        
        showFrame(frame);
    }
    
    public void listMovies() {
        ListMoviesInternalFrame frame = new ListMoviesInternalFrame();
        
        showFrame(frame);
    }

    private void showFrame(JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();

        Dimension frameSize = frame.getSize();

        frame.setLocation((desktopSize.width - frameSize.width)/2, (desktopSize.height- frameSize.height)/4);
        
        pane.add(frame);
        
        frame.setVisible(true);
    }
}
