package comboBoxModel;

import java.util.Arrays;

public class MovieKindComboBoxModel extends util.GenericComboBoxModel {
    
    public MovieKindComboBoxModel() {
        this(false);
    }
    
    public MovieKindComboBoxModel(boolean empty) {
        if (empty) {
            this.items = Arrays.asList("Todos", "Filme", "Documentário");
        } else {
            this.items = Arrays.asList("Filme", "Documentário");
        }
    }
    
}
