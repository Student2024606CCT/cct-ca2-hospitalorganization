package cctcollege.model;

/**
 *
 * Enum Manager
 * 
 * @author asafeds
 */
public enum Manager {
    
    MEDICAL_DIRECTOR("Medical Director"),
    
    NURSING_SUPERVISOR("Nursing Supervisor"),
    
    ADMINISTRATIVE_COORDINATOR("Administrative Coordinator");
    
    /**
     * 
     */
    
    private final String name;

    /**
     * Manager Constructor
     * @param name 
     */
    private Manager(String name) {
        this.name = name;
    }

    /**
     * Return name when parse Manager to string
     * @return 
     */
    @Override
    public String toString() {
        return name;
    }
    
}
