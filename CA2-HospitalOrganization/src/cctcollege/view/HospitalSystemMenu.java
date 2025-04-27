package cctcollege.view;

import cctcollege.model.Employee;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asafeds
 */
public class HospitalSystemMenu {
    
    public static final int SORT = 1;
    public static final int SEARCH = 2;
    public static final int ADD_RECORDS = 3;
    public static final int EXIT = 4;
    
    private final Scanner scanner;

    public HospitalSystemMenu() {
        scanner = new Scanner(System.in);
    }
    
    public int showMenu(){
        System.out.println("==== HOSPITAL SYSTEM ====");
        System.out.println("1. SORT");
        System.out.println("2. SEARCH");
        System.out.println("3. ADD RECORDS");
        System.out.println("4. EXIT");
        System.out.println("=========================");
        System.out.print("Choose an option: ");
        return askForNumber();
    }
    
    public void showConfigurationMenu(){
        System.out.println("============ HOSPITAL SYSTEM ============");
        System.out.println("1. PRESS 'ENTER' TO LOAD NAMES FROM FILE ");
        System.out.println("     (File: Applicants_Form.txt)   ");
        System.out.print("=========================================");
        scanner.nextLine();
    }
    
    public int showRecordsMenu(){
        System.out.println("====== ADD RECORDS =====");
        System.out.println("1. ADD EMPLOYEE");
        System.out.println("2. GENERATE RANDOM EMPLOYEE");
        System.out.println("=========================");
        System.out.print("Choose an option: ");
        return askForNumber();
    }

    public void displayEmployees(List<Employee> list){
        System.out.println("==== HOSPITAL SYSTEM || EMPLOYEES ====");
        list.forEach(e -> System.out.println(e.getName()));
        System.out.println("=========================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    }   
    
    public void displayEmployee(Employee employee){
        System.out.println("==== EMPLOYEE ====");
        System.out.println("Name: " + employee.getName());
        System.out.println("Manager: " + employee.getManagerType());
        System.out.println("Departament: " + employee.getDepartmentType());
        System.out.println("===================");
        System.out.print("Press any button to continue: ");
        scanner.nextLine();
    } 
    
    public void displayFileLoadedSuccessfuly(){
        System.out.println("[ File loaded successfully ]");
    }
    
    public void displaySortSuccessfuly(){
        System.out.println("[ Employees sorted successfully ]");
    }
    
    public String askForEmployeeName(){
        System.out.print("Please, inform the employee's name: ");
        return scanner.nextLine();
    }
    
    private int askForNumber(){
        try{
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            return 0;
        }
    }
    
}
