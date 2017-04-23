# cOkE (Connie & Kenny)


### Our Design 
We adapted our ArrayPriorityQueue so that it could take any class implementing Comparable. Then we wrote our class Ticket implementing Comparable, keeping in mind that we had to rewrite compareTo so that it would work with our ArrayPriorityQueue.  
Our HelpDesk works by asking a series of questions and having that humans can only ask for a limited number of services. We also made sure that we had exceptions so that random responses wouldn't be accepted. We have a string array that holds the available services based on priority order meaning the first service is highest priority. We also have another array that holds the corresponding messages that will be printed to a user when we process their ticket. After processing, we ask the user if they want to open another ticket. They have the option of saying yes, which will lead back to the ticket-creating process. Our method of generating IDs is to use an instance variable that will be updated each time that ID is used. We decided you couldn't use random numbers because you might land on the same number and it also limits the number of IDs.

### Embellishments
We added toString methods to easily see information about the Ticket and ArrayPriorityQueue.
