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
        welcomeMessage();
        homeScreen();
    }

    // method for the welcome message
    public static void  welcomeMessage(){
        System.out.println("********************************* ");
        System.out.println("                                  ");
        System.out.println("                                  ");
        System.out.println("          PRETTY PENNY             ");
        System.out.println("    Cute outfits, cuter profits    ");
        System.out.println("                                   ");
        System.out.println("                                   ");
        System.out.println("**********************************");
    }

    //method to for home screen
    public static void homeScreen() {
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
            String userChoice = userInput.nextLine().trim().toUpperCase();
            //create a switch statment to direct the choices in to the desired output
            switch (userChoice) {
                case "D" -> System.out.println();
                case "P" -> System.out.println("payment");
                case "L" -> System.out.println();
                case "X" -> {
                    System.out.println(" Closing!");
                    appRunning = false;
                }
                default -> System.out.println("That's not on the menu. Pick again!");
            }
        }
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
        writeTransaction(payment);

        System.out.println("Payment saved successfully!");
    }




}



