package com.pluralsight;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DepositAndPayment {

    public static void addDeposit() throws IOException {

        // Ask the user what the deposit is for
        System.out.print("Enter deposit description: ");
        String description = userInput.nextLine();

        // Ask where the money came from
        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        // Ask how much money was deposited
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(userInput.nextLine());

        // Make sure the deposit is positive
        if (amount <= 0) {
            System.out.println("Deposit must be greater than zero.");
            return;
        }

        // Get the current date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Create a new transaction
        Transaction deposit = new Transaction(
                date, time, description, vendor, amount
        );

        // Save the deposit into the CSV file
        ReadWriteTransaction.writeTransaction (deposit);

        System.out.println("Deposit saved successfully!");
    }



    public static void makePayment() throws IOException {

        // Ask what the payment was for
        System.out.print("Enter payment description: ");
        String description = userInput.nextLine();

        // Ask who received the payment
        System.out.print("Enter vendor: ");
        String vendor = userInput.nextLine();

        // Ask how much was paid
        System.out.print("Enter payment amount: ");
        double amount = Double.parseDouble(userInput.nextLine());

        // Make sure the amount is greater than zero
        if (amount <= 0) {
            System.out.println("Payment must be greater than zero.");
            return;
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

        System.out.println("Payment saved successfully!");
    }

}
