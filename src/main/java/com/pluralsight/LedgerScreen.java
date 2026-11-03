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

                case "R" -> System.out.println("");

                // Stops the loop and goes back to the home screen
                case "H" -> ledgerRunning = false;

                default -> System.out.println("Invalid choice!");
            }
        }

    }
    public static void showTransactions(String choice) throws IOException {

        // Calling the read method to get the saved transactions
        ArrayList<Transaction> transactions =
                AccountingLedgerApp.readTransactions();


        // Looping through the list backwards to show newest entries first
        for (int i = transactions.size() - 1; i >= 0; i--) {

            //getting one transaction from list
            Transaction transaction = transactions.get(i);
            if (choice.equals("A")) {
                //showing all the transactions
                printTransaction(transaction);
            }
            else if (choice.equals("D") && transaction.getAmount() > 0) {
                //showing deposits
                printTransaction(transaction);

            }
            else if (choice.equals("P") && transaction.getAmount() < 0) {
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
            System.out.println("Amount: $" + transaction.getAmount());

        }


    }


