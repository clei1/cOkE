/*======================================
  class Ticket
  The class that will be used for HelpDesk, holds the ID, name of person, description and priority of problem
  ======================================*/

public class Ticket implements Comparable<Ticket> {

    //instance variables
    private int ID, priority;
    private String description, nincompoop;

    // constructor -- initializes instance vars
    public Ticket(int newID, String descrip, int prior, String lummox){
	ID = newID;
	description = descrip;
	priority = prior;
	nincompoop = lummox;
    }

    //--------------v  ACCESSORS  v--------------

    //returns ID
    public int getID(){
	return ID;
    }

    //returns priority
    public int getPriority(){
	return priority;
    }

    //returns decription of problem
    public String getDescription(){
	return description;
    }

    //returns human name
    public String getUsername(){
	return nincompoop;
    }
    
    //--------------^  ACCESSORS  ^--------------

    //--------------v  MUTATORS  v--------------

    public void setPriority(int prior){
	priority = prior;
    }
    
    //--------------^  MUTATORS  ^--------------

    //compareTo based on priority of Ticket
    public int compareTo(Ticket other){
	return priority - other.getPriority();
    }

    //override inherited toString
    public String toString(){
	return "" + priority;
    }

}
