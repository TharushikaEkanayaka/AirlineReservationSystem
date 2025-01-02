public class Passenger {
    private String fName;
    private String lName;
    private String NIC;
    private String contactNo;
    private String flightNo;

    public Passenger (String fName, String lName, String NIC, String contactNo, String flightNo){
        this.fName = fName;
        this.lName = lName;
        this.NIC = NIC;
        this.contactNo = contactNo;
        this.flightNo = flightNo;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public String getNIC() {
        return NIC;
    }

    public String getContactNo() {
        return contactNo;
    }


    public String getFlightNo() {
        return flightNo;
    }
}
