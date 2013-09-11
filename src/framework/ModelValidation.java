package framework;

import java.util.Collection;
import java.util.HashMap;

public abstract class ModelValidation {
    
    private HashMap errors;
    
    protected abstract void validateRules();
    
    public boolean isValid() {
        validate();
        
        return errors.isEmpty();
    }
    
    public HashMap getErrors() {
        return errors;
    }
    
    public Collection getFullErrorMessages() {
        return errors.values();
    }
    
    private void validate() {
        errors = new HashMap();
        
        validateRules();
    }
    
    protected void addError(String key, String message) {
        errors.put(key, message);
    }
    
}
