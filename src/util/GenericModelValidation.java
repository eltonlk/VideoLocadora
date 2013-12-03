package util;

import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Pattern;

public abstract class GenericModelValidation {
    
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
        this.errors = new HashMap();
        
        validateRules();
    }
    
    protected void addError(String key, String message) {
        errors.put(key, message);
    }
    
    public static class ValidationUtils {
        
        private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        private static Pattern pattern;
        
        public static boolean isEmpty(Object object) {
            return object.toString().isEmpty();
        }
        
        public static boolean emailInvalid(String email) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            
            return !isEmpty(email) && !pattern.matcher(email).matches();
        }
        
    }
    
}