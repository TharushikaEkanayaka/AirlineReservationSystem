import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Reservation r = new ReservationSystem();
        int x = 0;
        r.flightDetailsFromFile();
        r.ticketFromFile();
        while (x==0){
            System.out.println("........MENU........");
            System.out.println("View airline details: 1");
            System.out.println("Add a passenger: 2");
            System.out.println("Delete a passenger: 3");
            System.out.println("Save in a file: 4");
            System.out.println("View ticket details: 5");
            System.out.println("Exit the programme: 6");

            System.out.print("\nEnter your option from the menu: ");
            String a = input.next();

            switch (a) {
                case "1":
                    r.viewAirline();
                    break;

                case "2":
                    r.addPassenger();
                    break;

                case "3":
                    r.deletePassenger();
                    break;

                case "4":
                    r.saveTicketInfo();
                    break;

                case "5":
                    r.viewTicket();
                    break;

                case "6":
                    System.out.println("\nEXIT the programme!!");
                    break;

                default:
                    System.out.println("\nInvalid option. Please enter a valid option from the menu.\n");
            }
            if (a.equals("6")) {
                break;
            }
        }
    }
}
