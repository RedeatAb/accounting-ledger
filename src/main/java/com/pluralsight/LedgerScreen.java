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
            String choice = AccountingLedgerApp.userInput
                    .nextLine().trim().toUpperCase();
    }
}
