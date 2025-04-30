package cctcollege;

import cctcollege.controller.HospitalSystemController;
import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
import cctcollege.view.HospitalMenu;
import cctcollege.view.HospitalSystemView;

/**
 *
 * @author asafeds
 */
public class CA2HospitalOrganization {

    
    public static void main(String[] args) {
        // Setting variables ...
        HospitalSystemController controller = new HospitalSystemController();
        HospitalSystemView view = new HospitalSystemView();
        
        // Starting system | Configuration menu ... 
        view.showConfigurationMenu();
        controller.loadEmployeesFromFile();
        view.displayFileLoadedSuccessfuly();
        
        // Main menu ... 
        while(true) {
            HospitalMenu menuOption = view.showMenu();
            if(menuOption == null) continue; //Invalid user choice
            switch (menuOption) {
                case HospitalMenu.LIST -> {
                    view.displayEmployees(controller.getEmployees());
                }
                case HospitalMenu.SORT -> {
                    controller.sortEmployees();
                    view.displaySortSuccessfuly();
                    view.displayEmployees(controller.getEmployees(), 20);
                }
                case HospitalMenu.SEARCH -> {
                    String name = view.askForEmployeeName();
                    view.displayEmployee(controller.searchEmployee(name));
                }
                case HospitalMenu.ADD_EMPLOYEE -> {
                    String name = view.askForEmployeeName();
                    Department dprt = view.askForDepartment();
                    Manager mnr = view.askForManager();
                    Employee employee = controller.addEmployee(name, mnr, dprt);
                    view.displayEmployeeAddedSuccessfuly(employee);
                    view.displayEmployee(employee);
                }
                case HospitalMenu.GENERATE_EMPLOYEE -> {
                    Employee randomOne = controller.newRandomEmployee();
                    view.displayEmployeeAddedSuccessfuly(randomOne);
                    view.displayEmployee(randomOne);
                }case HospitalMenu.EXIT -> {
                    return;
                }
            }
        }
        
    }
    
}
