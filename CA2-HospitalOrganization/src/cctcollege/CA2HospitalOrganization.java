package cctcollege;

import cctcollege.controller.HospitalSystemController;
import cctcollege.model.Employee;
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
        
        // Main menu ... 
        int menuChoice;
        do {
            menuChoice = view.showMenu();
            switch (menuChoice) {
                case HospitalSystemMenu.SORT -> {
                    controller.sortEmployees();
                    view.displaySortSuccessfuly();
                    view.displayEmployees(controller.getEmployees());
                }
                case HospitalSystemMenu.SEARCH -> {
                    String name = view.askForEmployeeName();
                    view.displayEmployee(controller.searchEmployee(name));
                }
                case HospitalSystemMenu.ADD_RECORDS -> {
                    view.showRecordsMenu();
                    //TODO
                }
            }
        } while (menuChoice != HospitalSystemMenu.EXIT);
        
    }
    
}
