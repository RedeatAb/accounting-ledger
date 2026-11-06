package com.pluralsight;
//importing date time and scanner

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//class handles adding deposit and payments
public class DepositAndPayment {

    // Use the same shared Scanner from the main app
    static Scanner userInput = AccountingLedgerApp.userInput;


    public static void addDeposit() {

        // Ask the user what the deposit is for
        System.out.print("Enter deposit description: ");
        String description = userInput.nextLine();

        // Ask where the money came from
        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        // Store the deposit amount
        double amount;

        // Keep asking until the amount is valid
        while (true) {

            System.out.print("Enter deposit amount: ");
            String input = userInput.nextLine();

            try {
                // Convert input to a number
                amount = Double.parseDouble(input);

                // Check if the amount is valid
                if (!Double.isFinite(amount) || amount <= 0) {
                    System.out.println("Bestie, enter an amount greater than zero!");
                    continue; // Ask again
                }

                break; // Stop loop if valid

            } catch (NumberFormatException e) {
                System.out.println("Oops bestie! Numbers only, please.");
            }
        }

        // Get current date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Create a deposit transaction
        Transaction deposit = new Transaction(
                date, time, description, vendor, amount
        );

        // Save deposit into the CSV file
        ReadWriteTransaction.writeTransaction(deposit);


    }


    public static void makePayment() {

        // Ask what the payment was for
        System.out.print("Enter payment description: ");
        String description = userInput.nextLine();

        // Ask who received the payment
        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        // Ask how much was paid
        double amount;
        // Keep asking until the amount is valid
        while (true) {

            System.out.print("Enter payment amount: ");
            String input = userInput.nextLine();

            try {
                // Convert input to a number
                amount = Double.parseDouble(input);

                if (!Double.isFinite(amount) || amount <= 0) {
                    System.out.println("Bestie, enter an amount greater than zero!");
                    continue; // ask again
                }

                break;// Stop loop if valid

            } catch (NumberFormatException e) {
                System.out.println("Oops bestie! Numbers only, please.");
            }
        }

        // Convert payment into a negative amount because it is a payment
        amount = -amount;

        // Get current date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Create a payment transaction
        Transaction payment = new Transaction(
                date, time, description, vendor, amount
        );

        // Save payment into the CSV file
        ReadWriteTransaction.writeTransaction(payment);


    }

}
