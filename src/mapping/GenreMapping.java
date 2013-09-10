package mapping;

import model.Genre;
import view.genre.FormPanel;

public class GenreMapping {
    
    private FormPanel formPanel;
    
    public GenreMapping(FormPanel formPanel) {
        this.formPanel = formPanel;
    }
    
    public void toForm(Genre genre) {
        formPanel.getLabelId().setText( Integer.toString(genre.getId()) );
        formPanel.getInputName().setText( genre.getName() );
//        formPanel.getInputCel().setText( genre.getCel() );
    }    
    
    public Genre toGenre() {
        Genre genre = new Genre();
        
        if ( !"".equals( formPanel.getLabelId().getText() ) ) {
            genre.setId( Integer.parseInt(formPanel.getLabelId().getText()) );
        }
        
        genre.setName( formPanel.getInputName().getText() );
//        genre.setActive( formPanel.getInputPhone().getText() );
        
        return genre;
    }  
    
}