package cctcollege.model;

/**
 *
 * @author asafeds
 */
public enum Department {
    
    /**
     * Handles urgent and critical cases
     */
    EMERGENCY("Emergency"),
    
    /**
     * Intensive Care Unit for critical patients
     */
    ICU("Intensive Care Unit"),
    
    /**
     * Specialized in the treatment of heart diseases
     */
    CARDIOLOGY("Cardiology"),
    
    /**
     * Responsible for imaging tests (X-rays, CT scans, MRIs, etc.)
     */
    RADIOLOGY("Radiology");
    
    /**
     * 
     */
    
    private final String name;

    private Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
    
}
