package cctcollege.controller;

import cctcollege.model.Employee;
import cctcollege.util.MyEmployeeList;
import cctcollege.util.GenerateRandomEmployeeUtil;
import java.util.List;

/**
 *
 * @author asafeds
 */
public class HospitalSystemController {
    
    private final MyEmployeeList employees;

    public HospitalSystemController() {
        employees = new MyEmployeeList();
    }
    
    public void loadEmployeesFromFile(){
        //DUMMY NAMES .... 
        List<String> names = GenerateRandomEmployeeUtil.getRandomNames();
        names.forEach(name -> {
            employees.add(new Employee(name,
                GenerateRandomEmployeeUtil.getRandomManager(),
                GenerateRandomEmployeeUtil.getRandomDepartment())
            );
        });
    }

    public void sortEmployees(){
        employees.sort();
    }
    
    public Employee searchEmployee(String name){
        return employees.searchByName(name);
    }

    public MyEmployeeList getEmployees() {
        return employees;
    } 
        
    
}
