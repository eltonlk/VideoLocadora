package mapping;

import model.Genre;
import view.genre.FormPanel;

public class GenreMapping {
    
    private FormPanel formPanel;
    
    public GenreMapping(FormPanel formPanel) {
        this.formPanel = formPanel;
    }
    
    public void toForm(Genre genre) {
        if (genre.getId() != 0 ) {
            formPanel.getLabelId().setText( Integer.toString(genre.getId()) );
        } else {
            formPanel.getLabelId().setText("");
        }
                
        formPanel.getInputName().setText( genre.getName() );
        formPanel.getSelectStatus().setSelectedItem( genre.getStatus() );
    }    
    
    public Genre toGenre() {
        Genre genre = new Genre();
        
        if ( !"".equals( formPanel.getLabelId().getText() ) ) {
            genre.setId( Integer.parseInt(formPanel.getLabelId().getText()) );
        }
        
        genre.setName( formPanel.getInputName().getText() );
        genre.setStatus( (String) formPanel.getSelectStatus().getSelectedItem() );
        
        return genre;
    }  
    
}