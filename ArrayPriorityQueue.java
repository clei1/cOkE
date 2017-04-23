/*======================================
  class ArrayPriorityQueue
  Implements an queue that inserts elements at the end of the queue, but removes elements based on priority first, then order.

operation	worst case	average case
add            	   O(1)            O(1)
peekMin	           O(n)	           O(n)
removeMin	   O(n)	           O(n)
  ======================================*/

import java.util.ArrayList; //need to import our underlying data structure

public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>{ //implements interface, typecasts ArrayPriorityQueue with a Comparable T

    //instance variable
    private ArrayList<T> _queue;

    //constructor -- initializes instance variable
    public ArrayPriorityQueue(){
	_queue = new ArrayList<T>();
    }

    //--------------v  PriorityQueue interface methods  v--------------

    //adds an item to this priority queue
    public void add(T x) {
	_queue.add(x);
    }

    //returns true if this stack is empty, otherwise return false
    public boolean isEmpty() {
	return _queue.isEmpty(); //ArrayList already has a function for isEmpty() so we can just call on that
    }

    //returns, but does not remove the smallest item stored in this priority queue
    //throws RuntimeException - if the priority queue is empty
    public T peekMin() {
	if (isEmpty()) //exception throwing according to the API
	    throw new RuntimeException();
	else {
	    T temp = _queue.get(0);
	    for (int counter = 1 ; counter < _queue.size() ; counter ++) {
		if ((_queue.get(counter).compareTo(temp)) < 0)
		    temp = _queue.get(counter);
	    }
	    return temp;
	}
    }

    //removes and returns the smallest item stored in this priority queue
    //throws RuntimeException - if the priority queue is empty
    public T removeMin(){
	if (isEmpty()) //exception throwing according to the API
	    throw new RuntimeException();
	else{
	    int position = 0;
	    for (int counter = 1 ; counter < _queue.size() ; counter ++){ //iterates through the entire ArrayList looking for the T with the smallest priority
		if (_queue.get(counter).compareTo(_queue.get(position)) < 0){
		    position = counter;
		}
	    }
	    return _queue.remove(position);
	}
    }
    
    //--------------^  PriorityQueue interface methods  ^--------------

    //overwritten toString method;
    public String toString() {
	String print = "[";
	for(T i : _queue) {
	    print += " ";
	    print += i;
	}
	print += " ]";
	return print;
    }

    //main method for testing
    public static void main(String[] args) {

	PriorityQueue david = new ArrayPriorityQueue();
	System.out.println("Testing toString method: " + david);
	System.out.println("Testing isEmpty method: " + david.isEmpty());

	System.out.println("Testing adding");
	System.out.println(david);
	david.add(0);
	david.add(50);
	david.add(15);
	david.add(0);
	System.out.println(david);

	System.out.println("Testing isEmpty method: " + david.isEmpty());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());

	//should throw a runtime error exception
	System.out.println("Testing remove when empty");
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());

    }//end main
    
}//end class
