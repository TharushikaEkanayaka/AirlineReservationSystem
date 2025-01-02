public class Flight {
    private String flightNo;
    private int seatCount;
    private String departure;
    private String arrival;

    public Flight(String flightNo, int seatCount, String departure, String arrival){
        this.flightNo = flightNo;
        this.seatCount = seatCount;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
