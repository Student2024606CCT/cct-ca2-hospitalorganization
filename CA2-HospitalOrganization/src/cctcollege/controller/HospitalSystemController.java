package cctcollege.controller;

import cctcollege.model.Employee;
import cctcollege.util.GenerateRandomEmployeeUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asafeds
 */
public class HospitalSystemController {
    
    private final List<Employee> employees;

    public HospitalSystemController() {
        this.employees = new ArrayList<>();
    }
    
    public void loadEmployeesFromFile(){
        List<String> names = loadNamesFromFile();
        names.forEach(name -> {
            employees.add(new Employee(name,
                GenerateRandomEmployeeUtil.getRandomManager(),
                GenerateRandomEmployeeUtil.getRandomDepartment())
            );
        });
    }
    
    // TODO - Load names from real file
    private List<String> loadNamesFromFile(){
        // Mocked for while ... 
        return GenerateRandomEmployeeUtil.getRandomNames();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
        
    
}
