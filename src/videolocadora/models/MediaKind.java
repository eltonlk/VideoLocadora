package videolocadora.models;

public enum MediaKind {
    
    DVD("DVD"),
    BluRay("Blu-Ray"),
    VHS("VHS");
    
    private final String name;
    
    MediaKind(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}
