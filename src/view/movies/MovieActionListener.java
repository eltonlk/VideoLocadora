package view.movies;

import model.MovieTableModel;
import view.components.toolbar.BaseToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mapping.MovieMapping;
import model.Movie;

import service.MovieService;
import view.components.message.BaseMessage;

public class MovieActionListener implements ActionListener, ListSelectionListener {

    private BaseToolBar toolbar;
    private final MovieInternalFrame frame;
    private MovieMapping mapping;
    private MovieService service;
    private MovieTableModel tableModel;
    private JTable table;

    MovieActionListener(MovieInternalFrame frame) {
        this.frame = frame;
    }
   
    public void initComponents() {
        this.mapping = new MovieMapping( frame.getFormPanel() );
        
        this.service = new MovieService();
        
        this.toolbar = frame.getToolBar();
        
        this.table = frame.getTablePanel().getTable();
        
        loadTBPeople();        
    }
    
    @Override
    public void valueChanged(ListSelectionEvent event) {
        Movie movie = tableModel.getMovie( table.getSelectedRow() );
        
        mapping.toForm(movie);
        
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
        tableModel = new MovieTableModel(service.getAll());
        
        table.setModel(tableModel);
        
        table.getSelectionModel()
                .addListSelectionListener( this );
    }    
    
    private void add() {
        mapping.toForm(new Movie());
        
        frame.getFormPanel().enableOrDisableFields(true);
        
        toolbar.enableButtonsToSave();
    }
    
    private void edit() {
        frame.getFormPanel().enableOrDisableFields(true);
        
        toolbar.enableButtonsToSave();
    }
    
    private void destroy() {
        if (BaseMessage.confirmDestroy()) {
            Movie movie = mapping.toMovie();

            service.destroy(movie);

            tableModel.removeMovie(movie);        
            
            BaseMessage.destroyInfo();
        }
    }
    
    private void save() {
        Movie movie = mapping.toMovie();
        
        if (service.save(movie)) {
            tableModel.addMovie(movie);
            
            frame.getFormPanel().enableOrDisableFields(false);
            
            toolbar.disableButtonsToSave();      
        }
        
        BaseMessage.form(frame, movie);
    }
    
    private void cancel() {
        frame.getFormPanel().enableOrDisableFields(false);
        
        toolbar.disableButtonsToSave();
    }
    
}
