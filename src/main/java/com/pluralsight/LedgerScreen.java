package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class LedgerScreen {
    // Creating a method for the ledger menu
    public static void showLedger() throws IOException {
        // Using a boolean to keep the menu running
        boolean ledgerRunning = true;
        // Loop until the LoginScreen chooses to go back
        while (ledgerRunning) {

            System.out.println(Colors.NEON_PINK +
                    "\n             ******       ******");
            System.out.println("          ***      *** ***      ***");
            System.out.println("        **            *            **");
            System.out.println("       *                             *");

            System.out.println(Colors.LAVENDER +
                    "      *       ♡ THE MONEY DIARIES ♡   *");

            System.out.println(Colors.PALE_PINK +
                    "      *                               *");
            System.out.println("       *   A) All Transactions       *");
            System.out.println("        *  D) Deposits Only         *");
            System.out.println("         * P) Payments Only        *");
            System.out.println("          * R) Reports            *");

            System.out.println(Colors.PURPLE +
                    "           * H) Back to Glam Room*");

            System.out.println(Colors.NEON_PINK +
                    "            *                   *");
            System.out.println("              *               *");
            System.out.println("                *           *");
            System.out.println("                  *       *");
            System.out.println("                    *   *");
            System.out.println("                      *" + Colors.RESET);

            // Getting the LoginScreen's input from the main class
            System.out.print(Colors.NEON_PINK +
                    "\nChoose wisely: " + Colors.RESET);


            String choice = AccountingLedgerApp.userInput.nextLine().trim().toUpperCase();

            // Switch statement for the different ledger options
            switch (choice) {

                case "A" -> showTransactions("A");

                case "D" -> showTransactions("D");

                case "P" -> showTransactions("P");

                case "R" -> ReportScreen.showReports();

                // Stops the loop and goes back to the home screen
                case "H" -> ledgerRunning = false;

                default -> System.out.println("Invalid choice!");
            }
        }

    }

    public static void showTransactions(String choice) throws IOException {

        // Calling the read method to get the saved transactions
        ArrayList<Transaction> transactions =
                ReadWriteTransaction.readTransactions();

        // Sort transactions from newest to oldest
        ReportScreen.sortTransactions(transactions);
        //printing the header
        ReportScreen.printHeader();


        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

            // Get one transaction
            Transaction transaction = transactions.get(i);

            // Check which transactions the LoginScreen wants to see
            if (choice.equals("A")) {
                //showing all the transactions
                printTransaction(transaction);
            } else if (choice.equals("D") && transaction.getAmount() > 0) {
                //showing deposits
                printTransaction(transaction);

            } else if (choice.equals("P") && transaction.getAmount() < 0) {
                //showing payments
                printTransaction(transaction);

            }

        }
    }

    // This method prints each transaction in one row
    public static void printTransaction(Transaction transaction) {

        // Stores the color used for the transaction amount
        String amountColor;

        // Checks if the transaction is a deposit or payment
        if (transaction.getAmount() > 0) {
            // Green for deposits
            amountColor = Colors.GREEN;
        } else {
            // Red for payments
            amountColor = Colors.RED;
        }
        // Formats the time to show only hours and minutes
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        // Prints transaction details in one row
        // Each number controls the space between columns
        // Prints each transaction in one row with equal spacing
        System.out.printf(
                "%-12s %-10s %-35s %-25s %s%10.2f%s%n",

                transaction.getDate(),             // Date column
                transaction.getTime().format(timeFormat), // Time column
                transaction.getDescription(),      // Description column
                transaction.getVendor(),           // Vendor column
                amountColor,                       // Amount color
                transaction.getAmount(),           // Amount value
                Colors.RESET                       // Reset text color
        );
    }


}





