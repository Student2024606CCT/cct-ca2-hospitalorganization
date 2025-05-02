package cctcollege.model;

/**
 * Entity Employee
 * 
 * @author asafeds
 */
public class Employee implements Comparable<Employee> {
    
    private String name;
    private Manager managerType;
    private Department departmentType;

    /**
     * Employee constructor
     * @param name
     * @param managerType
     * @param departmentType 
     */
    public Employee(String name, 
            Manager managerType, 
            Department departmentType) {
        this.name = name;
        this.managerType = managerType;
        this.departmentType = departmentType;
    }

    /**
     * Get employee name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Set employee name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get employee manager type 
     * @return 
     */
    public Manager getManagerType() {
        return managerType;
    }

    /**
     * Set employee manager type
     * @param managerType 
     */
    public void setManagerType(Manager managerType) {
        this.managerType = managerType;
    }

    /**
     * Get employee department type
     * @return 
     */
    public Department getDepartmentType() {
        return departmentType;
    }

    /**
     * Set employee department type
     * @param departmentType 
     */
    public void setDepartmentType(Department departmentType) {
        this.departmentType = departmentType;
    }

    /**
     * Method used to compare employees when sort employee list
     * @param e
     * @return 
     */
    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.getName());
    }
    
    
}
