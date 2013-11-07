package mapping;

import framework.MyDate;
import model.Genre;
import model.Movie;
import view.movies.FormPanel;

public class MovieMapping {

    private final FormPanel formPanel;
    
    public MovieMapping(FormPanel formPanel) {
        this.formPanel = formPanel;
    }
    
    public void toForm(Movie movie) {
        if (movie.getId() != 0) {
            formPanel.getLabelId().setText( Integer.toString(movie.getId()) );
        } else {
            formPanel.getLabelId().setText("");
        }        
        
        formPanel.getInputTitle().setText( movie.getTitle() );
        formPanel.getInputReleaseIn().setValue( movie.getReleaseIn().toLocaleString() );
        formPanel.getSelectGenre().setSelectedItem( movie.getGenre() );
        formPanel.getTextAreaSynopsis().setText( movie.getSynopsis() );
        
        formPanel.getMediasListPanel().loadMedias( movie.getMedias() );
        
        formPanel.getActorsListPanel().loadActors( movie.getActors() );
        
        formPanel.repaint();
    }    
    
    public Movie toMovie() {
        Movie movie = new Movie();
        
        if ( !"".equals( formPanel.getLabelId().getText() ) ) {
            movie.setId( Integer.parseInt(formPanel.getLabelId().getText()) );
        }
        
        movie.setTitle( formPanel.getInputTitle().getText() );
        movie.setReleaseIn( MyDate.strptime(formPanel.getInputReleaseIn().getText()).getDate() );
        movie.setGenre( (Genre) formPanel.getSelectGenre().getSelectedItem());
        movie.setSynopsis( formPanel.getTextAreaSynopsis().getText() );

        movie.setActors( formPanel.getActorsListPanel().getTableModel().getItems() );
        
        movie.setMedias( formPanel.getMediasListPanel().getTableModel().getItems() );        
        
        return movie;
    }
    
}
