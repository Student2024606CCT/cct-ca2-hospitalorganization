
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
  
    /**
     * An instance of Random used to generate random values throughout
     * the application. This instance is shared and reused to avoid creating
     * multiple Random objects unnecessarily.
     */
    private static final Random random = new Random();
    
    /**
     * Default names as list to select randomly 
     */
    private static final List<String> randomNames = Arrays.asList(
            "Brody Matthews",
            "Clara Bennett",
            "Miles Foster",
            "Naomi Hayes",
            "Leo Griffin",
            "Ruby Stephens",
            "Asher Barnes",
            "Alice Chapman",
            "Eli Wheeler",
            "Jade Franklin",
            "Nolan Powers",
            "Vivian Douglas",
            "Austin Barrett",
            "Ivy Malone",
            "Caleb Norton",
            "Elena Holt",
            "Aaron Doyle",
            "Daisy Harmon",
            "Hunter Pierce"
        );
    
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
     * Get a random Employee NAME  
     * @return 
     */

    public static String getRandomName() {
        int index = random.nextInt(randomNames.size());
        return randomNames.get(index);
    }
    
}
