package cctcollege.model;

/**
 *
 * @author asafeds
 */
public class Employee {
    
    private String name;
    private Manager managerType;
    private Department departmentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManagerType() {
        return managerType;
    }

    public void setManagerType(Manager managerType) {
        this.managerType = managerType;
    }

    public Department getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Department departmentType) {
        this.departmentType = departmentType;
    }
    
    
    
}
