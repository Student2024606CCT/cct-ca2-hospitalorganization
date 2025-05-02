package cctcollege.util;

import cctcollege.model.Employee;
import java.util.ArrayList;

/**
 * 
 * Custom list for storing Employee objects. 
 * Inherits from ArrayList and adds quicksort and search features.
 *
 * @author asafeds
 */
public class MyEmployeeList 
        extends ArrayList<Employee> 
        implements QuickSort,Search<Employee>{
    
    /**
     * isSorted - Variable responsible for defining 
     * the state of the list whether it is ordered or not
     */
    private boolean isSorted = Boolean.FALSE;
    
    /**
     * 
     * =========================================
     * ============== QUICK SORT ===============
     * =========================================
     * 
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

    /**
     * Recursively sorts the list using quicksort. 
     * Splits the list around a pivot and sorts each part.
     *
     * @param low
     * @param high
     */
    private void qsRecursive(int low, int high) {
        if (low < high) {
            int pivotIndex = qsPartition(low, high);
            // Recursively sort elements before and after partition
            qsRecursive(low, pivotIndex - 1);
            qsRecursive(pivotIndex + 1, high);
        }
    }
    
    /**
     * Does the partitioning part of quicksort. 
     * Puts everything smaller than the pivot to the left, 
     * and bigger things to the right
     * 
     * @param low
     * @param high
     * @return the index where the pivot ends up
     */
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

    /**
     * Swaps two employees in the list at positions i and j.
     *
     * @param i
     * @param j
     */
    private void qsSwap(int i, int j) {
        Employee temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }

    /**
     * ========================================= 
     * ============ LINEAR SEARCH ============== 
     * =========================================
     *
     * Recursive linear search implementation.
     *
     * @param name
     * @param index
     * @return Employee.
     */
    private Employee linearSearchRecursive(String name, int index) {
        // Reached the end of the list
        if (index >= size()) return null;
        // Found the employee
        Employee employee = this.get(index);
        //Comparting names
        if (employee.getName().equalsIgnoreCase(name)) return employee;
        // Recurse to the next index
        return linearSearchRecursive(name, index + 1);
    }

    /**
     * ========================================= 
     * ============ BINARY SEARCH ============== 
     * =========================================.
     *
     * Recursive binary search implementation.
     *
     * @param name The name to search for.
     * @param low The starting index of the search range.
     * @param high The ending index of the search range.
     * @return The Employee if found, or null if not found.
     */
    private Employee binarySearchRecursive(String name, int low, int high) {
        if (low > high) return null; // Base case: name not found
        int mid = (low + high) / 2;
        Employee midEmployee = this.get(mid);
        //Comparing names
        int comparison = midEmployee.getName().compareToIgnoreCase(name);
        if (comparison == 0) {
            // Name found
            return midEmployee;
        } else if (comparison > 0) {
            // Search left half
            return binarySearchRecursive(name, low, mid - 1);
        } else {
            // Search right half
            return binarySearchRecursive(name, mid + 1, high);
        }
    }

    /**
     * 
     * Searches for an employee by name using either binary search or linear
     * search, depending on whether the list is currently sorted.
     * 
     * If the list is sorted, a  binary search is used.
     * If the list is not sorted, a linear search is used.
     *
     * @param name
     * @return
     */
    @Override
    public Employee searchByName(String name) {
        if (isSorted) {
            return binarySearchRecursive(name, 0, this.size() - 1);
        } else {
            return linearSearchRecursive(name, 0);
        }
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
