package cctcollege.util;

import cctcollege.model.Employee;
import java.util.ArrayList;

public class MyEmployeeList 
        extends ArrayList<Employee> 
        implements QuickSort {
    
    /**
     * isSorted - Variable responsible for defining 
     * the state of the list whether it is ordered or not
     */
    private boolean isSorted = Boolean.FALSE;
    
    /**
     * Sorts the list using the QuickSort algorithm.
     */
    @Override
    public void quickSort() {
        // QuickSort has poor performance when the list is already sorted, 
        // so we have state control to not execute the algorithm 
        // if the list is already sorted.
        if(isSorted || this.size() <= 1) return;
        // Sorting list ... 
        qsRecursive(0, this.size() - 1);
        isSorted = Boolean.TRUE;
    }

    private void qsRecursive(int low, int high) {
        if (low < high) {
            int pivotIndex = qsPartition(low, high);
            // Recursively sort elements before and after partition
            qsRecursive(low, pivotIndex - 1);
            qsRecursive(pivotIndex + 1, high);
        }
    }

    private int qsPartition(int low, int high) {
        Employee pivot = this.get(high); // Choose the last element as pivot
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            // Compare employees using their compareTo method (by name)
            if (this.get(j).compareTo(pivot) <= 0) {
                i++;
                qsSwap(i, j); // Swap if current element is less than or equal to pivot
            }
        }
        qsSwap(i + 1, high); // Place the pivot in the correct position
        return i + 1;
    }

    private void qsSwap(int i, int j) {
        Employee temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
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
    
    /**
     * 
     * Overriding method to ensure 
     * that the list state will change to new record
     * (isSorted = false) 
     * 
     * @param e
     * @return 
     */

    @Override
    public boolean add(Employee e) {
        isSorted = Boolean.FALSE;
        return super.add(e);
    }

    
    
    

}
