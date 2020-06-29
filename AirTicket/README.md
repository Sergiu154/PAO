### AirTicket - Airline reservation system

#### Checkpoint #1
___

#### Modeling the system
	
The actual version of the app comprises 8 types of objects

* *Ticket*
* *DiscountTicket* and *FirstClassTicket* which extend the Ticket class.
*  *Seat* 
* *Airplane*
* *Airport*
* *Flight*
* *Client*

### System functionalities
* A client can book a ticket for a certain flight, select a destination, the departure date and the option for a round trip ticket.
* The system registers the client, requiring him/her to enter the necessary personal data such as *email address*, *name*, *age*.
* The client can opt for an upgraded luggage size or a business class ticket which includes some special perks.
* At the end of the process, the systems shows the summary of the order, offering the client the possibility to book another ticket.
* Each client has a list(*ArrayList*) of purchased tickets which is ordered by the departure date.
* The system uses a *HashMap* to check if a selected *Seat* is available.
* Also, there are created the necessary objects for collecting essential information ( the tickets which are associated to a certain flight, and information about the airplane). Further data such as the airport object will be used in a possible implementation which involves the use of a database.

	