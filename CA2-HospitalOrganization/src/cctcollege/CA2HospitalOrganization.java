package cctcollege;

import cctcollege.controller.HospitalSystemController;
import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
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
                case HospitalSystemMenu.LIST -> {
                    view.displayEmployees(controller.getEmployees());
                }
                case HospitalSystemMenu.SORT -> {
                    controller.sortEmployees();
                    view.displaySortSuccessfuly();
                    view.displayEmployees(controller.getEmployees());
                }
                case HospitalSystemMenu.SEARCH -> {
                    String name = view.askForEmployeeName();
                    view.displayEmployee(controller.searchEmployee(name));
                }
                case HospitalSystemMenu.ADD_EMPLOYEE -> {
                    String name = view.askForEmployeeName();
                    Department dprt = view.askForDepartment();
                    Manager mnr = view.askForManager();
                    Employee employee = controller.addEmployee(name, mnr, dprt);
                    view.displayEmployeeAddedSuccessfuly(employee);
                    view.displayEmployee(employee);
                }
                case HospitalSystemMenu.GENERATE_EMPLOYEE -> {
                    Employee randomOne = controller.newRandomEmployee();
                    view.displayEmployeeAddedSuccessfuly(randomOne);
                    view.displayEmployee(randomOne);
                }
            }
        } while (menuChoice != HospitalSystemMenu.EXIT);
        
    }
    
}
