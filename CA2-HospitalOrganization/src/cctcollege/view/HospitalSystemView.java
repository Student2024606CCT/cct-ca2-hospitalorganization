package cctcollege.view;

import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asafeds
 */
public class HospitalSystemView {

    private static final String DEFAULT_FILE = "default_applicants_form.txt";
    
    private final Scanner scanner;

    public HospitalSystemView() {
        scanner = new Scanner(System.in);
    }

    public HospitalMenu showMenu() {
        HospitalMenu menuChoice;
        System.out.println("============ HOSPITAL SYSTEM ============");
        menuChoice = (HospitalMenu) askFromEnumOptions(HospitalMenu.values());
        System.out.println("=========================================");
        return menuChoice;
    }
    
    public void showConfigurationMenu() {
        System.out.println("============= HOSPITAL SYSTEM ============");
        System.out.println("ENTER THE FILE NAME (FULL PATH) TO LOAD ");
        System.out.println("OR PRESS 'ENTER' TO USE DEFAULT FILE");
        System.out.println("e.g.: /Users/student/Desktop/myfile.txt");
        System.out.println("==========================================");
    }

    public void displayEmployees(List<Employee> list) {
        System.out.println("====== HOSPITAL SYSTEM || EMPLOYEES =====");
        list.forEach(e -> System.out.println(e.getName()));
        System.out.println("=========================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }
    
    public void displayEmployees(List<Employee> list, int max) {
        System.out.println("====== HOSPITAL SYSTEM || EMPLOYEES("+ max +") =====");
        list.stream().limit(max).forEach(e -> System.out.println(e.getName()));
        System.out.println("=========================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }

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

    public void displayFileLoadedSuccessfuly(String file) {
        System.out.printf("[ File \"%s\" loaded successfully ]\n",file);
    }

    public void displaySortSuccessfuly() {
        System.out.println("[ Employees sorted successfully ]");
    }

    public void displayEmployeeAddedSuccessfuly(Employee employee) {
        System.out.printf(
            "[ \"%s\" has been added as \"%s\" to \"%s\" successfully! ]\n",
            employee.getName(),
            employee.getManagerType(),
            employee.getDepartmentType()
        );
    }
    
    public String askForFileName(){
        System.out.print("=>");
        String file = scanner.nextLine();
        // If 'file' is blank return default file name
        return file.trim().equalsIgnoreCase("") ? DEFAULT_FILE : file; 
    }

    public Department askForDepartment() {
        System.out.println("---------------------------");
        System.out.println("Please select a department:");
        return (Department) askFromEnumOptions(Department.values());
    }

    public Manager askForManager() {
        System.out.println("---------------------------");
        System.out.println("Please select a role:");
        return (Manager) askFromEnumOptions(Manager.values());
    }

    private Object askFromEnumOptions(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int choice;
        while (true) {
            System.out.print("Choose an option(1-" + options.length + "): ");
            choice = askForNumber();
            if (choice >= 1 && choice <= options.length) {
                return options[choice - 1]; // Adjust for 0-based index
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String askForEmployeeName() {
        System.out.print("Please, inform the employee's full name: ");
        return scanner.nextLine();
    }

    private int askForNumber() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
