import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Get user input for number of rows and seats per row
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        //Initialize cinema seating
        char[][] cinema = new char[rows][seatsPerRow];

        //Fill the seating arrangement with 'S' (available seats)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                cinema[i][j] = 'S';
            }
        }

        //Calculate total income
        int totalIncome = calculateTotalIncome(rows, seatsPerRow);
        int purchasedTickets = 0;
        int currentIncome = 0;

        //Menu loop
        while (true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printCinema(cinema);
                    break;
                case 2:
                    int ticketPrice = buyTicket(scanner, cinema, rows, seatsPerRow);
                    if (ticketPrice > 0) { //Successful purchase
                        purchasedTickets++;
                        currentIncome += ticketPrice;
                    }
                    break;
                case 3:
                    showStatistics(purchasedTickets, rows, seatsPerRow, currentIncome, totalIncome);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void printCinema(char[][] cinema){
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinema[0].length; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < cinema.length; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cinema[i].length; j++){
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int buyTicket(Scanner scanner, char[][] cinema, int rows, int seatsPerRow){
        while (true) {
            System.out.println("Enter a row number:");
            int selectedRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int selectedSeat = scanner.nextInt();

            //Validate Input
            if (selectedRow < 1 || selectedRow > rows || selectedSeat < 1 || selectedSeat > seatsPerRow) {
                System.out.println("Wrong input!");
                continue;
            }

            //Check if seat is already booked
            if (cinema[selectedRow - 1][selectedSeat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }

            //Determine ticket price
            int ticketPrice = calculateTicketPrice(rows, selectedRow, seatsPerRow);

            //Display ticket price
            System.out.println("Ticket price: $" + ticketPrice);

            //Mark the selected seat as booked
            cinema[selectedRow - 1][selectedSeat - 1] = 'B';
            return ticketPrice;
        }
    }

    public static void showStatistics(int purchasedTickets, int rows, int seatsPerRow, int currentIncome, int totalIncome) {
        int totalSeats = rows * seatsPerRow;
        double occupancyRate = (double) purchasedTickets / totalSeats * 100;

        System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", occupancyRate);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public static int calculateTicketPrice(int rows, int selectedRow, int seatsPerRow) {
        int totalSeats = rows * seatsPerRow;
        if (totalSeats <= 60) {
            return 10;
        } else {
            int frontHalfRows = rows / 2;
            return (selectedRow <= frontHalfRows) ? 10 : 8;
        }
    }

    public static int calculateTotalIncome(int rows, int seatsPerRow) {
        int totalSeats = rows * seatsPerRow;
        if (totalSeats <= 60) {
            return totalSeats * 10;
        } else {
            int frontHalfRows = rows / 2;
            int backHalfRows = rows - frontHalfRows;
            return (frontHalfRows * seatsPerRow * 10) + (backHalfRows * seatsPerRow * 8);
        }
    }
}