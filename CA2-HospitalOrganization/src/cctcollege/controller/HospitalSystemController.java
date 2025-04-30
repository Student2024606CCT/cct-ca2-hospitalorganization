package cctcollege.controller;

import cctcollege.model.Department;
import cctcollege.model.Employee;
import cctcollege.model.Manager;
import cctcollege.util.MyEmployeeList;
import cctcollege.util.GenerateRandomEmployeeUtil;

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
        // MOCK // DUMMY NAMES .... 
        GenerateRandomEmployeeUtil.getRandomNames()
            .forEach(name -> addEmployee(name,
                GenerateRandomEmployeeUtil.getRandomManager(),
                GenerateRandomEmployeeUtil.getRandomDepartment())
            );
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
