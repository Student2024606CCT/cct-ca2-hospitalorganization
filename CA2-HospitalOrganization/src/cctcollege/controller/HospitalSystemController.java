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
    
    private final String FILE_TXT = "Applicants_Form.txt";
    
    private final MyEmployeeList employees;

    public HospitalSystemController() {
        employees = new MyEmployeeList();
    }
    
    public void loadEmployeesFromFile(){
        try {
            // Read all lines/names from the file and store them in the list
            List<String> names = Files.readAllLines(Paths.get(FILE_TXT));
            // Add employees from list of names
            names.forEach(name -> addEmployee(name,
                GenerateRandomEmployeeUtil.getRandomManager(),
                GenerateRandomEmployeeUtil.getRandomDepartment())
            );
        } catch (IOException e) {
            // Print an error message if the file cannot be read
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public void sortEmployees(){
        employees.quickSort();
    }
    
    public Employee searchEmployee(String name){
        return employees.searchByName(name);
    }

    public MyEmployeeList getEmployees() {
        return employees;
    } 
    
    public Employee addEmployee(String name, Manager mngr, Department dept) {
        Employee employee = new Employee(name, mngr, dept);
        employees.add(employee);
        return employee;
    }

    public Employee newRandomEmployee() {
        return addEmployee(
            GenerateRandomEmployeeUtil.getRandomName(),
            GenerateRandomEmployeeUtil.getRandomManager(),
            GenerateRandomEmployeeUtil.getRandomDepartment()
        );
    }
        
    
}
