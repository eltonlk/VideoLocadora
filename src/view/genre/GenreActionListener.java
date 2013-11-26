package view.genre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mapping.GenreMapping;
import model.Genre;
import model.GenreTableModel;
import service.GenreService;
import view.components.message.BaseMessage;
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
        
        toolbar.disableButtonsToSave();
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
        mapping.toForm(new Genre());
        
        frame.getFormPanel().enableOrDisableFields(true);
        
        toolbar.enableButtonsToSave();
    }
    
    private void edit() {
        frame.getFormPanel().enableOrDisableFields(true);
        
        toolbar.enableButtonsToSave();
    }
    
    private void destroy() {
        if (BaseMessage.confirmDestroy()) {
            Genre genre = mapping.toGenre();

            service.destroy(genre);

            tableModel.removeGenre(genre);                    
        
            BaseMessage.destroyInfo();
        }
    }
    
    private void save() {
        Genre genre = mapping.toGenre();
        
        if (service.save(genre)) {
            tableModel.addGenre(genre);

            frame.getFormPanel().enableOrDisableFields(false);
            
            toolbar.disableButtonsToSave();      
        }
        
        BaseMessage.form(frame, genre);
    }
    
    private void cancel() {
        frame.getFormPanel().enableOrDisableFields(false);
        
        toolbar.disableButtonsToSave();
    }
    
}
