import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class ReservationSystem implements Reservation {
    static ArrayList<Passenger> passengerList = new ArrayList<>();
    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static int seatCount1, seatCount2, seatCount3, seatCount4, seatCount5;
    static String price;
    static Scanner input = new Scanner(System.in);

    public void addPassenger(){
        //flightDetailsFromFile();
        System.out.println("............Passenger Details..........");
        System.out.print("Enter Passenger First Name: ");
        String fName = input.next();
        System.out.print("Enter Passenger Last Name: ");
        String lName = input.next();
        System.out.print("Enter Passenger NIC no: ");
        String NIC = input.next();
        System.out.print("Enter Passenger Contact No: ");
        String contactNo = input.next();
        System.out.println("\n...Flight Options...");
        System.out.println("Sri Lanka to Melbourne: 1");
        System.out.println("Sri Lanka to Singapore: 2");
        System.out.println("Sri Lanka to Malaysia: 3");
        System.out.println("Sri Lanka to New York: 4");
        System.out.println("Sri Lanka to Dubai: 5");
        System.out.print("\nEnter the correct option from the list: ");
        int option = input.nextInt();

        String flightNo = "0";
        if (option == 1) {
            flightNo = "AU30987";
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (f.getFlightNo().equals(flightNo)) {
                    seatCount1 = f.getSeatCount();
                    seatCount1--;
                    System.out.println("\nRemaining seats in the airline = " + seatCount1 + "\n");
                    price = "LKR250,000";
                    break;
                }
            }
        } else if (option == 2) {
            flightNo = "SI48902";
            for (int j = 0; j < flights.size(); j++) {
                Flight f = flights.get(j);
                if (f.getFlightNo().equals(flightNo)) {
                    seatCount2 = f.getSeatCount();
                    seatCount2--;
                    System.out.println("\nRemaining seats in the airline = " + seatCount2 + "\n");
                    price = "LKR150,000";
                    break;
                }
            }
        } else if (option == 3) {
            flightNo = "MA34562";
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (f.getFlightNo().equals(flightNo)) {
                    seatCount3 = f.getSeatCount();
                    seatCount3--;
                    System.out.println("\nRemaining seats in the airline = " + seatCount3 + "\n");
                    price = "LKR125,000";
                    break;
                }
            }
        } else if (option == 4) {
            flightNo = "NY54372";
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (f.getFlightNo().equals(flightNo)) {
                    seatCount4 = f.getSeatCount();
                    seatCount4--;
                    System.out.println("\nRemaining seats in the airline = " + seatCount4 + "\n");
                    price = "LKR375,000";
                    break;
                }
            }
        } else if (option == 5) {
            flightNo = "DU63287";
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (f.getFlightNo().equals(flightNo)) {
                    seatCount5 = f.getSeatCount();
                    seatCount5--;
                    System.out.println("\nRemaining seats in the airline = " + seatCount5 + "\n");
                    price = "LKR425,000";
                    break;
                }
            }
        }

        System.out.print("Enter your flight date (dd/MM/YY): ");
        String date = input.next();

        Random rand = new Random();
        int ticketNumber = rand.nextInt(900000) + 100000;

        Passenger passenger = new Passenger(fName, lName, NIC, contactNo, flightNo);
        passengerList.add(passenger);

        Ticket ticket = new Ticket(fName, lName, NIC, contactNo, flightNo, ticketNumber, price, date);
        tickets.add(ticket);

        System.out.print("\n...." + passenger.getFirstName() + " " + passenger.getLastName() + " was successfully added to the system.....");
        System.out.println("\n");
        System.out.println(" ");
    }

    public void deletePassenger() {
        System.out.print("\nEnter the NIC of the passenger that you want to delete: ");
        String delPassenger = input.next();
        boolean passengerFound = false;
        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            if (t.getNIC().equals(delPassenger)) {
                for (int j=0; j<passengerList.size(); j++){
                    Passenger p = passengerList.get(j);
                    if (p.getNIC().equals(t.getNIC())){
                        passengerList.remove(j);
                    }
                }
                System.out.println("\n" + t.getFirstName() + " " + " has been successfully deleted and ticket "+t.getTicketNo()+" has been deleted.\n");
                tickets.remove(i);

                String fNo = t.getFlightNo();
                switch (fNo) {
                    case "AU30987" -> {
                        seatCount1++;
                        System.out.println("Remaining seats in the airline = " + seatCount1 + "\n");
                    }
                    case "SI48902" -> {
                        seatCount2++;
                        System.out.println("Remaining seats in the airline = " + seatCount2 + "\n");
                    }
                    case "MA34562" -> {
                        seatCount3++;
                        System.out.println("Remaining seats in the airline = " + seatCount3 + "\n");
                    }
                    case "NY54372" -> {
                        seatCount4++;
                        System.out.println("Remaining seats in the airline = " + seatCount4 + "\n");
                    }
                    case "DU63287" -> {
                        seatCount5++;
                        System.out.println("Remaining seats in the airline = " + seatCount5 + "\n");
                    }
                }
                passengerFound = true;
                break;
            }
        }
        if (passengerFound == false){
            System.out.println("There is no passenger with the given NIC number");
            System.out.println(" ");
        }
    }

    public void flightDetailsFromFile(){
        try{
            String fileName = "C:\\Users\\pc\\Desktop\\University of Kelaniya\\YR 1 SEM 2\\AirlineReservation\\src\\flightDetails";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(" ");
                String flightNo = info[0];
                int seatCount = Integer.parseInt(info[1]);
                String departure1 = info[2];
                String departure2 = info[3];
                String departure = departure1 + " " + departure2;
                String arrival = info[4];

                switch (flightNo){
                    case "AU30987":
                        seatCount1 = seatCount;
                    case "SI48902":
                        seatCount2 = seatCount;
                    case "MA34562":
                        seatCount3 = seatCount;
                    case "NY54372":
                        seatCount4 = seatCount;
                    case "DU63287":
                        seatCount5 = seatCount;
                }

                Flight flight = new Flight(flightNo, seatCount, departure, arrival);
                flights.add(flight);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void viewAirline(){
        for(Flight fl : flights){
            System.out.println("\nFlight no: " + fl.getFlightNo() + "\nSeat count: " + fl.getSeatCount() + "\nDeparture: " + fl.getDeparture() + "\nArrival: " + fl.getArrival());
        }
        System.out.println("\n");
    }

    public void saveTicketInfo(){
        try {
            String fileName = "C:\\Users\\pc\\Desktop\\University of Kelaniya\\YR 1 SEM 2\\AirlineReservation\\src\\TicketInfo";
            FileWriter myFile = new FileWriter(fileName);
            for(int i=0; i<tickets.size(); i++) {
                Ticket tk = tickets.get(i);
                myFile.append(tk.getFirstName() + "\t" + tk.getLastName() + "\t" + tk.getNIC() + "\t" + tk.getFlightNo() + "\t" + tk.getTicketNo() + "\t" + tk.getFlightDate() + "\t" + tk.getPrice() + "\t" + tk.getContactNo() +"\n");
            }
            myFile.close();
            System.out.println("\nSuccessfully saved in the file.\n");
        } catch (IOException e) {
            System.out.println("\nAn error occurred.\n");
            e.printStackTrace();
        }
    }

    public void ticketFromFile(){
        try{
            String fileName = "C:\\Users\\pc\\Desktop\\University of Kelaniya\\YR 1 SEM 2\\AirlineReservation\\src\\TicketInfo";
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = b.readLine()) != null) {
                String[] info = line.split("\t");
                String firstName =info[0];
                String lastName = info[1];
                String id = info[2];
                String flightNo = info[3];
                String tNo = info[4];
                int no = Integer.parseInt(tNo);
                String flightDate = info[5];
                String price = info[6];
                String contactNo = info[7];

                Ticket t = new Ticket(firstName, lastName, id, contactNo, flightNo, no, price, flightDate);
                tickets.add(t);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void viewTicket(){
        System.out.print("Enter your NIC no: ");
        String idNo = input.next();
        boolean foundTicket = false;
        for (int i = 0; i < tickets.size(); i++) {
            Ticket tc = tickets.get(i);
            if (tc.getNIC().equals(idNo)) {
                String flight = tc.getFlightNo();
                for (int j = 0; j < flights.size(); j++) {
                    Flight f = flights.get(j);
                    if (f.getFlightNo().equals(flight)) {
                        System.out.println("\nFirst Name: " + tc.getFirstName() + "\nLast Name: " + tc.getLastName() + "\nNIC: " + tc.getNIC() + "\nContact No: " + tc.getContactNo() + "\nFlight No: " + tc.getFlightNo() + "\nTicket No: " + tc.getTicketNo() + "\nTicket Price: " + tc.getPrice() + "\nFlight date: " + tc.getFlightDate() + "\nDeparture: " + f.getDeparture() + "\nArrival: " + f.getArrival());
                        break;
                    }
                }
                foundTicket = true;
            }
        }
        if (foundTicket == false){
            System.out.println("No ticket issued for the given NIC number");
        }
        System.out.println("\n");
    }
}
