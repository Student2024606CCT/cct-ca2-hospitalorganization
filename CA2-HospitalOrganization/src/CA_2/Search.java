package CA_2;

/**
 *
 * Search<T>
 *
 * A generic interface that defines a contract for searching elements.
 * Classes implementing this interface must provide an implementation for
 * searching an element of type T based (Example: Search<Employee>).
 * 
 * @author asafeds
 */
public interface Search<T> {
    
    /**
     * 
     * Search object by name
     * 
     * @param name
     * @return 
     */
    public T searchByName(String name);

}
