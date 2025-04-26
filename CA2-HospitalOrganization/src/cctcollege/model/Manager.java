package cctcollege.model;

/**
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

    private Manager(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
