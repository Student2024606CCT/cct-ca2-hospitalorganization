package cctcollege.controller;

import cctcollege.util.GenerateRandomEmployeeUtil;
import java.util.List;

/**
 *
 * @author asafeds
 */
public class HospitalSystemController {
    
    // TODO - Load names from real file
    public List<String> loadNamesFromFile(){
        // Mocked for while ... 
        return GenerateRandomEmployeeUtil.getRandomNames();
    }
        
    
}
