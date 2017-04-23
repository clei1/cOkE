/*======================================
  class HelpDesk
  Fixes problems
  ======================================*/

import cs1.Keyboard;

public class HelpDesk{

    //instance variables
    private ArrayPriorityQueue<Ticket> _data;
    private int IDcount;

    //these never change
    private String[] servicesAll = {"reinstall OS", "dispatch tech", "password reset"};
    private String[] serviced = {"Your OS has been reinstalled.", "One of the HelpDesk is coming to assist you immediately.", "Your password has been reset to your company ID number."};

    // constructor -- initializes remaining instance vars
    public HelpDesk(){
	_data = new ArrayPriorityQueue<Ticket>();
	IDcount = 666;
    }

    //asks a human about her/his problem and creates an appriopriate ticket
    public void createTicket(){
	System.out.println("Hello, my name is HelpDesk. What is your name?");
	String name = Keyboard.readString();

	System.out.println("Hello " + name + "! I am only able to provide these services below. Please choose the number the corresponds with the closest service you desire.");
	for(int service = 0; service < servicesAll.length; service++){ //iterates through the provided services and prints them out with a corresponding number
	    System.out.println(service + ": " + servicesAll[service]);
	}
	System.out.println(servicesAll.length + ": " + "Never mind, you can't solve my problem"); //exit
	    
	int priority = Keyboard.readInt();
	while(priority > servicesAll.length ||
	      priority < 0){ //if they don't enter in a number within bounds, Keyboard takes care of if they don't enter a number
	    System.out.println("Error: Human intelligence subpar");
	    priority = Keyboard.readInt();
	}
	if(priority == servicesAll.length){ //exit
	    System.out.println("Very sorry, " + name + ", but have a nice day.");
	}
	else{
	    _data.add(new Ticket(IDcount, servicesAll[priority], priority, name)); //creates and adds a new Ticket
	    IDcount++; //updates the counter so IDs are never the same
	}
    }

    //goes through the tickets and finds the highest priority one, if multiple same priorities, then first one
    //then prints the corresponding processed ticket response
    //gives human a chance to create a new ticket
    public void processTicket(){
        if(!_data.isEmpty()){
	    String processed = "";
	    Ticket processing = _data.removeMin();
	    processed += ("Hello, " + processing.getUsername()  + ", the HelpDesk is working on resolving your issue!\n ");
	    for(int service = 0; service < servicesAll.length; service++){ //gets corresponding processed ticket response
		if(processing.getDescription().equals(servicesAll[service])){
		    processed += serviced[service];
		    break; //once it finds it, end the loop
		}
	    }
	    processed += "\n Thank you so much for contacting us! We hope you are satisfied with your service!\n Can we help you with anything else? \n0: Yes \n1: No";
	    System.out.println(processed);
	    int answer = Keyboard.readInt();
	    while(answer != 0 && answer != 1){
		System.out.println("HelpDesk does not understand your language.");
		answer = Keyboard.readInt();
	    }
	    if(answer == 1)
		System.out.println("Have a wonderful problem free day!");
	    else
	        continueTicket(processing.getUsername()); //slightly different message than just calling create ticket
	    
	}
	else //You can't process tickets if there aren't any tickets to process.
	    System.out.println("No more tickets left to process.");  
    }

    //similar function with createTicket
    public void continueTicket(String name){
	System.out.println("Please choose a service:");
	for(int service = 0; service < servicesAll.length; service++){
	    System.out.println(service + ": " + servicesAll[service]);
	}
	int priority = Keyboard.readInt();
	while(priority >= servicesAll.length ||
	      priority < 0){
	    System.out.println("Error: Human intelligence subpar");
	    priority = Keyboard.readInt();
	}
	_data.add(new Ticket(IDcount, servicesAll[priority], priority, name));
	IDcount++; //updates the counter so IDs are never the same
    }

    //overwritten toString method;
    public String toString(){
	return _data.toString();
    }
    
    //main method for testing;
    public static void main(String[] args){
	HelpDesk Anna = new HelpDesk();
	Anna.createTicket();
	System.out.println(Anna);
	Anna.createTicket();
	System.out.println(Anna);
	Anna.createTicket();
	System.out.println(Anna);
	Anna.processTicket();
	Anna.processTicket();
	Anna.processTicket();
	Anna.processTicket();
	HelpDesk Elsa = new HelpDesk();
	Elsa.processTicket();

    }//end main
    
}//end class
