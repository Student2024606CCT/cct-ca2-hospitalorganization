package cctcollege.view;

import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
import java.util.List;
import java.util.Scanner;


/**
 * Handles all user interface interactions for the Hospital System.
 * Responsible for displaying menus, showing messages, 
 * and getting input from the user.
 *
 * @author asafeds
 */
public class HospitalSystemView {

    private static final String DEFAULT_FILE = "default_applicants_form.txt";
    
    private final Scanner scanner;

    public HospitalSystemView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu and asks the user to choose an option.
     *
     * @return the selected HospitalMenu option
     */
    public HospitalMenu showMenu() {
        HospitalMenu menuChoice;
        System.out.println("============ HOSPITAL SYSTEM ============");
        menuChoice = (HospitalMenu) askFromEnumOptions(HospitalMenu.values());
        System.out.println("=========================================");
        return menuChoice;
    }
    
    /**
     * Shows a configuration screen prompting the user to enter a file path or
     * press enter to use a default file.
     */
    public void showConfigurationMenu() {
        System.out.println("============= HOSPITAL SYSTEM ============");
        System.out.println("ENTER THE FILE NAME (FULL PATH) TO LOAD ");
        System.out.println("OR PRESS 'ENTER' TO USE DEFAULT FILE");
        System.out.println("e.g.: /Users/student/Desktop/myfile.txt");
        System.out.println("==========================================");
    }

    /**
     * Displays the names of all employees in the given list. 
     * Waits for the user to press a key to continue.
     *
     * @param list the list of employees to display
     */
    public void displayEmployees(List<Employee> list) {
        System.out.println("====== HOSPITAL SYSTEM || EMPLOYEES =====");
        list.forEach(e -> System.out.println(e.getName()));
        System.out.println("=========================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }
    
    /**
     * Displays up to a maximum number of employees from the given list.
     * Useful for showing just a portion of a long list.
     *
     * @param list the list of employees
     * @param max the maximum number of employees to display
     */
    public void displayEmployees(List<Employee> list, int max) {
        System.out.println("====== HOSPITAL SYSTEM || EMPLOYEES("+ max +") =====");
        list.stream().limit(max).forEach(e -> System.out.println(e.getName()));
        System.out.println("=========================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }

    /**
     * Displays detailed info about a single employee.
     * If employee is null, shows a 'not found' message.
     *
     * @param employee the employee to display
     */
    public void displayEmployee(Employee employee) {
        if(employee == null){
            System.out.println("[ Sorry, nothing found. ]");
        }else{
            System.out.println("==== EMPLOYEE ====");
            System.out.println("Name: " + employee.getName());
            System.out.println("Manager: " + employee.getManagerType());
            System.out.println("Departament: " + employee.getDepartmentType());
            System.out.println("===================");
        }
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }

    /**
     * Shows a success message when a file is loaded correctly.
     * 
     * @param file the file name that was loaded
     */
    public void displayFileLoadedSuccessfuly(String file) {
        System.out.printf("[ File \"%s\" loaded successfully ]\n",file);
    }

    /**
     * Shows a success message when employees have been sorted.
     */
    public void displaySortSuccessfuly() {
        System.out.println("[ Employees sorted successfully ]");
    }

    /**
     * Shows a confirmation message when a new employee is successfully added.
     *
     * @param employee the employee that was added
     */
    public void displayEmployeeAddedSuccessfuly(Employee employee) {
        System.out.printf(
            "[ \"%s\" has been added as \"%s\" to \"%s\" successfully! ]\n",
            employee.getName(),
            employee.getManagerType(),
            employee.getDepartmentType()
        );
    }
    
    /**
     * Asks the user to input a file name.
     * If the input is blank, returns the default file name.
     *
     * @return the provided or default file path
     */
    public String askForFileName(){
        System.out.print("=>");
        String file = scanner.nextLine();
        // If 'file' is blank return default file name
        return file.trim().equalsIgnoreCase("") ? DEFAULT_FILE : file; 
    }

    /**
     * Asks the user to choose a department from the list.
     *
     * @return the selected department
     */
    public Department askForDepartment() {
        System.out.println("---------------------------");
        System.out.println("Please select a department:");
        return (Department) askFromEnumOptions(Department.values());
    }

    /**
     * Asks the user to choose a manager role from the list.
     *
     * @return the selected manager
     */
    public Manager askForManager() {
        System.out.println("---------------------------");
        System.out.println("Please select a role:");
        return (Manager) askFromEnumOptions(Manager.values());
    }
    
    /**
     * Helper method to show a list of options (enums) 
     * and return the selected one.
     *
     * @param options array of options to choose from
     * @return the selected option
     */
    private Object askFromEnumOptions(Object[] options) {
        //Display all options (enum values)
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int choice; //Getting user choice ...
        while (true) {
            //loop until user inform a valid choice
            System.out.print("Choose an option(1-" + options.length + "): ");
            choice = askForNumber();
            //If its a valid choice, return enum object 
            if (choice >= 1 && choice <= options.length) {
                // Adjust for 0-based index
                return options[choice - 1]; 
            } else {
                //Ask for user enter a valid enum option
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    /**
     * Asks the user to input the full name of an employee.
     *
     * @return the name entered by the user
     */
    public String askForEmployeeName() {
        System.out.print("Please, inform the employee's full name: ");
        return scanner.nextLine();
    }

    /**
     * Tries to read a number from user input.
     * Returns 0 if input is invalid (e.g., not a number).
     *
     * @return the number entered, or 0 if invalid
     */
    private int askForNumber() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
