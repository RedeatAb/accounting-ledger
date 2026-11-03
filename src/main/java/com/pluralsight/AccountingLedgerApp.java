/*
Author: Redeat Abera
Date:11/02/2026
Purpose: This project is a Java app that lets a business add, save, and view its money coming in and going out.
 */

package com.pluralsight;
//Imports for reading the file, dates, times, and lists
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.format.DateTimeFormatter;


public class AccountingLedgerApp {
    //creating one static method in the class can share the same one
    static Scanner userInput = new Scanner(System.in);
    //creating static arraylist to be used
    static ArrayList<Transaction> transactions = new ArrayList<>();



    public static void main(String[] args)throws IOException {



        System.out.println("Transaction saved successfully!");


        System.out.println("********************************* ");
        System.out.println("                                  ");
        System.out.println("                                  ");
        System.out.println("          PRETTY PENNY             ");
        System.out.println("    Cute outfits, cuter profits    ");
        System.out.println("                                   ");
        System.out.println("                                   ");
        System.out.println("**********************************");

        //displaying the home screen
        boolean appRunning = true;
        // using the while loop to display the home screen
        while (appRunning) {
            System.out.println("\n  THE GLAM ROOM ");
            System.out.println("D) Treat your Wallet(Add Deposit)");
            System.out.println("P) Bills,Bills,Bills(make payment)");
            System.out.println("L) Spill the tea (View ledger)");
            System.out.println("X) Bye Bestie! (Exit)");
            System.out.print("\n Choose wisley: ");
            // string to store the user choice
            String userChoice =userInput.nextLine().trim().toUpperCase();
            //create a switch statment to direct the choices in to the desired output
            switch (userChoice) {
                case "D" -> System.out.println(" Deposit.");
                case "P" -> System.out.println("payment");
                case "L" -> System.out.println("ledger");
                case "X" -> {
                    System.out.println(" Closing!");
                    appRunning = false;
                }
                default -> System.out.println("That's not on the menu. Pick again!");
            }



        }


    }
    // create an array list method to give back the parsed list
    public static ArrayList<Transaction> readTransactions() throws IOException{
        //make the list inisde the method
        ArrayList<Transaction> parsedTransactions = new ArrayList<>();
        //open the file so we can read it line by line
        BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
        // Read the first line (the header) and skip it
        reader.readLine();
        //This line will hold one line at a time
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split("\\|");
            // Turn each piece into the right type
            LocalDate date = LocalDate.parse(parts[0]);
            LocalTime time = LocalTime.parse(parts[1]);
            String description = parts[2];
            String vendor = parts[3];
            double amount = Double.parseDouble(parts[4]);

            Transaction orderedTransaction = new Transaction(date, time , description , vendor , amount );
            parsedTransactions.add(orderedTransaction);
        }
        //closing the reader
        reader.close();
        //returning the parsed data
        return parsedTransactions;

    }
    //create  the write method
    public static void writeTransaction(Transaction transaction)throws IOException {
        // Open the CSV file and add new information
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("transactions.csv", true)
        );

        // Get the information from the Transaction object
        String line = transaction.getDate() + "|"
                + transaction.getTime().withNano(0) + "|"
                + transaction.getDescription() + "|"
                + transaction.getVendor() + "|"
                + transaction.getAmount();

        // Write the transaction into the file
        writer.write(line);

        // Move to a new line
        writer.newLine();

        // Close the writer
        writer.close();

    }
    // creating the method to add a deposit

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
        writeTransaction(deposit);

        System.out.println("Deposit saved successfully!");
    }



}



