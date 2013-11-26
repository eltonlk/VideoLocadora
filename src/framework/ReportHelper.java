package framework;

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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ReportHelper {
    
    private SessionFactory sessionFactory;
    private JasperReport report;
    private JasperPrint print;
    private HashMap params;
    private String report_name;

    public ReportHelper(String report_name, HashMap params) {
        this.report_name = report_name;
        this.params = params;
        this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }
    
    public void show() {
        try {
            this.report = JasperCompileManager.compileReport(getClass().getResourceAsStream("../view/reports/" + report_name + ".jrxml"));
            
            this.print = JasperFillManager.fillReport(report, params, sessionFactory.getCurrentSession().connection());
            
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage());
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
