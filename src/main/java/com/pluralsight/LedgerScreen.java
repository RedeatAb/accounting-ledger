package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

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

    // Method to print one transaction
    public static void printTransaction (Transaction transaction) {

        // Choose a color based on transaction type
        String amountColor;

        if (transaction.getAmount() > 0) {
            amountColor = Colors.GREEN;
        } else {
            amountColor = Colors.RED;
        }

        // Print transaction details
        System.out.println(Colors.LAVENDER + "Date: " + transaction.getDate() + Colors.RESET);

        System.out.println(Colors.LAVENDER + "Time: " + transaction.getTime().withNano(0) + Colors.RESET);

        System.out.println(Colors.PALE_PINK + "Description: " + transaction.getDescription() + Colors.RESET);

        System.out.println(Colors.PALE_PINK + "Vendor: " + transaction.getVendor() + Colors.RESET);

        System.out.printf(amountColor + "Amount: $%.2f%n" + Colors.RESET, transaction.getAmount());

        // Cute divider between transactions
        System.out.println(Colors.NEON_PINK + "♡ ─────────────────────────── ♡" + Colors.RESET);

        System.out.println();
    }


}





