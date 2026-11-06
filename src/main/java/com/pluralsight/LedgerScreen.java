package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class LedgerScreen {
    // Creating a method for the ledger menu
    public static void showLedger() throws IOException {
        // Using a boolean to keep the menu running
        boolean ledgerRunning = true;
        // Loop until the user chooses to go back
        while (ledgerRunning) {

            System.out.println("\n--- THE MONEY DIARIES ---");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits Only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Back to the Glam Room");

            // Getting the user's input from the main class
            System.out.print("Choose wisely: ");

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

        // Sort from newest to oldest
        transactions.sort((a, b) -> {
            // Compare the dates of two transactions
            int dateCompare = b.getDate().compareTo(a.getDate());
            // If dates are different, sort by date
            if (dateCompare != 0) {
                return dateCompare;
            }
            // If dates are the same, sort by time
            return b.getTime().compareTo(a.getTime());
        });


        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

            // Get one transaction
            Transaction transaction = transactions.get(i);

            // Check which transactions the user wants to see
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
    public static void printTransaction(Transaction transaction) {

        System.out.println("Date: " + transaction.getDate());
        System.out.println("Time: " + transaction.getTime().withNano(0));
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Vendor: " + transaction.getVendor());

        System.out.printf("Amount: $%.2f%n", transaction.getAmount());

    }


}


