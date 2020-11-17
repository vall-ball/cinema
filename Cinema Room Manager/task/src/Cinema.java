import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = Integer.parseInt(scanner.nextLine());

        String[][] array = new String[rows][seatsInRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                array[i][j] = "S";
            }
        }


        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int answer = Integer.parseInt(scanner.nextLine());

            switch (answer) {
                case 1:
                    showSeats(array);
                    break;
                case 2:
                    buyTicket(array);
                    break;
                case 3:
                    statistics(array);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }



    }

    private  static void showSeats(String[][] array) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void buyTicket(String[][] array) {
        while (true) {
            System.out.println("Enter a row number:");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter a seat number in that row::");
            int seat = Integer.parseInt(scanner.nextLine());
            if (row > array.length || seat > array[0].length) {
                System.out.println("Wrong input!");
                continue;
            }
            if (array[row - 1][seat - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            int price = 0;
            if (array.length * array[0].length <= 60) {
                price = 10;
            } else {
                if (row <= array.length / 2) {
                    price = 10;
                } else {
                    price = 8;
                }
            }
            System.out.print("Ticket price: $" + price);
            array[row - 1][seat - 1] = "B";
            break;
        }
    }

    private static void statistics(String[][] array) {
        int totalIncome = 0;
        if (array.length * array[0].length <= 60) {
            totalIncome = array.length * array[0].length * 10;
        } else {
            totalIncome = array[0].length * (array.length / 2 * 10 + (array.length - array.length / 2) * 8);
        }

        int numberOfPurchasedTickets = 0;
        int currentIncome = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j].equals("B")) {
                    numberOfPurchasedTickets++;
                    if (array.length * array[0].length <= 60) {
                        currentIncome += 10;
                    } else if (i <= array.length / 2) {
                        currentIncome += 10;
                    } else {
                        currentIncome += 8;
                    }
                }
            }
        }
        double percentage = (double) currentIncome / (double) totalIncome;
        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f", percentage );
        System.out.println("%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

}


/*







        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsInRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seatsInRow; j++) {
                if (i == row && j == seat) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }

            }
            System.out.println();
        }

 */