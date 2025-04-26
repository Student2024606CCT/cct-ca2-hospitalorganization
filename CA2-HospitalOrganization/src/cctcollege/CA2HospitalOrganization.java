package cctcollege;

import cctcollege.controller.HospitalSystemController;
import cctcollege.view.HospitalSystemMenu;

/**
 *
 * @author asafeds
 */
public class CA2HospitalOrganization {

    
    public static void main(String[] args) {
        // Setting variables ...
        HospitalSystemController controller = new HospitalSystemController();
        HospitalSystemMenu view = new HospitalSystemMenu();
        
        // Starting system | Configuration menu ... 
        view.showConfigurationMenu();
        controller.loadEmployeesFromFile();
        view.displayFileLoadedSuccessfuly();
        view.displayEmployees(controller.getEmployees());
        
        // Main menu ... 
        view.showMenu();
        
    }
    
}
