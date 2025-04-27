
package cctcollege.util;

import cctcollege.model.Employee;
import java.util.ArrayList;

public class MyEmployeeList extends ArrayList<Employee> {

    /**
     * 
     * Mock - Temporary Sort ....
     * 
     * TO DO - Implement real sort for employees
     * 
     */
    public void sort(){
        super.sort(null);
    }
    
    /**
     * 
     * Mock - Temporary Search ....
     * 
     * TO DO - Implement real search by name for employees
     * 
     * @param name
     * @return 
     */
     public Employee searchByName(String name) {
        for (Employee employee : this) {
            if (employee.getName().contains(name)) {
                return employee;
            }
        }
        return null;
    }
    
}
