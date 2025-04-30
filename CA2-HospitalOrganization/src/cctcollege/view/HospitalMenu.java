
package cctcollege.view;

/**
 *
 * Enum for menu options
 * 
 * @author asafeds
 */
public enum HospitalMenu {
    
                 LIST("LIST ALL EMPLOYEES"),
                 SORT("SORT EMPLOYEES "),
               SEARCH("SEARCH EMPLOYEE BY NAME"),
         ADD_EMPLOYEE("ADD EMPLOYEE"),
    GENERATE_EMPLOYEE("GENERATE RANDOM EMPLOYEE"),
                 EXIT("EXIT");
                 
    private final String description;

    HospitalMenu(String description) {
        this.description = description;
    }
    
    /**
     * 
     * Return enum description when convert obj to string
     * @return 
     */
    @Override
    public String toString() {
        return description;
    }
    
    

}

