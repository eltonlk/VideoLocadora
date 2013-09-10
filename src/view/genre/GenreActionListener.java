package view.genre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mapping.GenreMapping;
import model.Genre;
import model.GenreTableModel;
import service.GenreService;
import view.components.toolbar.BaseToolBar;

public class GenreActionListener implements ActionListener, ListSelectionListener {

    private BaseToolBar toolbar;
    private GenreInternalFrame frame;
    private GenreMapping mapping;
    private GenreService service;
    private GenreTableModel tableModel;
    private JTable table;

    GenreActionListener(GenreInternalFrame frame) {
        this.frame = frame;
    }
   
    public void initComponents() {
        this.mapping = new GenreMapping( frame.getFormPanel() );
        
        this.service = new GenreService();
        
        this.toolbar = frame.getBaseToolBar();
        
        this.table = frame.getTablePanel().getTable();
        
        loadTBPeople();        
    }
    
    @Override
    public void valueChanged(ListSelectionEvent event) {
        Genre genre = tableModel.getGenre( table.getSelectedRow() );
        
        mapping.toForm(genre);
    }    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "add":
                add();
                break;
            case "edit":
                edit();
                break;
            case "destroy":
                destroy();
                break;
            case "save":
                save();
                break;
            case "cancel":
                cancel();
                break;
        }
    }
    
    private void loadTBPeople() {
        tableModel = new GenreTableModel(service.getAll());
        
        table.setModel(tableModel);
        
        table.getSelectionModel()
                .addListSelectionListener( this );
    }    
    
    private void add() {
        toolbar.enableButtonsToSave();
    }
    
    private void edit() {
        toolbar.enableButtonsToSave();
    }
    
    private void destroy() {
        Genre genre = mapping.toGenre();
                
        service.destroy(genre);
        
        JOptionPane.showMessageDialog(frame, "Registro excluído.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        tableModel.removeGenre(genre);        
    }
    
    private void save() {
        Genre genre = mapping.toGenre();
        
        service.save(genre);
        
        JOptionPane.showMessageDialog(frame, "Registro salvo.", "save", JOptionPane.INFORMATION_MESSAGE);
        
        tableModel.addGenre(genre);
        
        toolbar.disableButtonsToSave();      
    }
    
    private void cancel() {
        toolbar.disableButtonsToSave();
    }
    
}
