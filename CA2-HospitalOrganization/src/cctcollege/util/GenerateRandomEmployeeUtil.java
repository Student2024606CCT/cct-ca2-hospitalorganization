
package cctcollege.util;

import cctcollege.model.Department;
import cctcollege.model.Manager;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author asafeds
 */
public class GenerateRandomEmployeeUtil {
    
    private static final Random random = new Random();
    
    /**
     * Get a random DEPARTAMENT type 
     * @return 
     */

    public static Department getRandomDepartment() {
        Department[] departments = Department.values();
        int index = random.nextInt(departments.length);
        return departments[index];
    }
    
    /**
     * Get a random MANAGER type 
     * @return 
     */

    public static Manager getRandomManager() {
        Manager[] managerTypes = Manager.values();
        int index = random.nextInt(managerTypes.length);
        return managerTypes[index];
    }
    
    /**
     * DUMMY DATA(20 NAMES)
     * @return 
     */
    
    public static List<String> getRandomNames(){
        return Arrays.asList(
            "Emily Johnson",
            "Liam Smith",
            "Olivia Brown",
            "Noah Davis",
            "Ava Wilson",
            "Ethan Thompson",
            "Isabella Martinez",
            "Mason Anderson",
            "Sophia Taylor",
            "James Moore",
            "Mia Harris",
            "Benjamin Clark",
            "Charlotte Lewis",
            "Elijah Walker",
            "Amelia Hall",
            "Lucas Young",
            "Harper Allen",
            "Logan King",
            "Emma Scott",
            "Jackson Wright"
        );
    }
    
}
