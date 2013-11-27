package comboBoxModel;

import java.util.List;
import java.util.Set;

public class ActorComboBoxModel extends util.GenericComboBoxModel {
    
    public ActorComboBoxModel(Set actors) {
        this.items = (List) actors;
    }
    
}
