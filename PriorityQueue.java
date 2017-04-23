/*****************************************************
 * interface PriorityQueue -- subset of actual Java List interface
 * Specifies actions a Deque must be able to perform.
 * If present in local dir, will take precedence over Java's 
 * built-in PriorityQueue interface.
 *****************************************************/

public interface PriorityQueue<T>{

    //adds an item to this priority queue
    public void add(T x);

    //returns true if this stack is empty, otherwise return false
    public boolean isEmpty();

    //returns, but does not remove the smallest item stored in this priority queue
    //throws RuntimeException - if the priority queue is empty
    public T peekMin();
    
    //removes and returns the smallest item stored in this priority queue
    //throws RuntimeException - if the priority queue is empty
    public T removeMin();

}
