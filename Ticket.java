public class Ticket extends Passenger {
    private int ticketNo;
    private String price;

    private String flightDate;

    public Ticket(String fName, String lName, String NIC, String contactNo, String flightNo, int ticketNo, String price, String flightDate){
        super(fName, lName, NIC, contactNo, flightNo);
        this.ticketNo = ticketNo;
        this.price = price;
        this.flightDate = flightDate;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String getPrice() {
        return price;
    }

    public String getFlightDate() {
        return flightDate;
    }
}
