# cOkE (Connie & Kenny)


### Our Design 
We adapted our ArrayPriorityQueue so that it would take a Comparable type T meaning we could use any instance of Ticket. Then we wrote our class Ticket, keeping in mind that we had to rewrite toCompare so that it would work with our ArrayPriorityQueue. Our HelpDesk works by asking a series of questions meaning that humans can only ask for a limited number of services. We also made sure that we had exceptions so that random things wouldn't be accepted. We have a string array that holds the avaliable services based on priority order meaning the first service is highest priority. We also have another array that holds the corresponding messages that will be printed to a user when we process their ticket. After processing, we ask the user if they want to open another ticket. They have the option of saying yes, which will lead back to the ticket creating process. Our mehtod of generating IDs is to use an instance variable that will be updated each time that ID is used. We decided you couldn't use random because you might land on the same number and it also limits the number of IDs.

### Embellishments
We don't really have embellishments, but those can be added to our list of services.
