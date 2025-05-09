package CA_2;

/**
 * 
 * Enum Department
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

    /**
     * Department Constructor
     * @param name 
     */
    private Department(String name) {
        this.name = name;
    }

    /**
     * Return name when parse Department to string
     * @return 
     */
    @Override
    public String toString() {
        return name;
    }
    
    
}
