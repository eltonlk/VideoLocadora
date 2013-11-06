package framework;

import framework.database.DataBaseConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportHelper {

    private DataBaseConnection connection;
    private JasperReport report;
    private JasperPrint print;
    private HashMap params;
    private String report_name;

    public ReportHelper(String report_name, HashMap params) {
        this.report_name = report_name;
        this.params = params;
        
        try {
            this.connection = new DataBaseConnection();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void show() {
        try {
            this.report = JasperCompileManager.compileReport(getClass().getResourceAsStream("../view/reports/" + report_name + ".jrxml"));
            
            this.print = JasperFillManager.fillReport(report, params, connection.getConnection());
            
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage());
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
