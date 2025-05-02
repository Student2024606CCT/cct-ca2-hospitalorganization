package cctcollege.controller;

import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
import cctcollege.util.MyEmployeeList;
import cctcollege.util.GenerateRandomEmployeeUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author asafeds
 */
public class HospitalSystemController {
        
    private final MyEmployeeList employees;

    /**
     * Initialize list in constructor
     */
    public HospitalSystemController() {
        employees = new MyEmployeeList();
    }
    
    /**
     * Loads a list of employee names from a file and adds them to the system,
     * assigning each a randomly generated manager and department.
     *
     * @param file the path to the file containing the employee names
     * @return true if the loading is successful, false if a read error occurs
     */
    public boolean loadEmployeesFromFile(String file){
        try {
            // Read all lines/names from the file and store them in the list
            List<String> names = Files.readAllLines(Paths.get(file));
            // Add employees from list of names
            names.forEach(name -> addEmployee(name,
                GenerateRandomEmployeeUtil.getRandomManager(),
                GenerateRandomEmployeeUtil.getRandomDepartment())
            );
            return Boolean.TRUE;
        } catch (IOException e) {
            // Print an error message if the file cannot be read
            System.err.println("Error reading the file: " + e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     * Sorts the employee list using the quick sort algorithm.
     */
    public void sortEmployees(){
        employees.quickSort();
    }
    
    /**
     * Searches for an employee by name in the employee list.
     *
     * @param name the name of the employee to search for
     * @return the found employee, or null if not found
     */
    public Employee searchEmployee(String name){
        return employees.searchByName(name);
    }

    /**
     * Returns the list of employees.
     *
     * @return the employee list
     */
    public MyEmployeeList getEmployees() {
        return employees;
    } 
    
    /**
     * Creates a new employee with the given name, manager, and department, and
     * adds them to the employee list.
     *
     * @param name 
     * @param mngr Manager enum
     * @param dept Department enum
     * @return the newly created employee
     */
    public Employee addEmployee(String name, Manager mngr, Department dept) {
        Employee employee = new Employee(name, mngr, dept);
        employees.add(employee);
        return employee;
    }

    /**
     * Creates a new employee with a randomly generated name, manager, and
     * department, and adds them to the employee list.
     *
     * @return the newly created employee
     */
    public Employee newRandomEmployee() {
        return addEmployee(
            GenerateRandomEmployeeUtil.getRandomName(),
            GenerateRandomEmployeeUtil.getRandomManager(),
            GenerateRandomEmployeeUtil.getRandomDepartment()
        );
    }
        
    
}
