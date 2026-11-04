/*
Author: Redeat Abera
Date:11/02/2026
Purpose: This project is a Java app that lets a business add, save, and view its money coming in and going out.
 */

package com.pluralsight;
//Imports for scanner array list and error handling

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;


public class AccountingLedgerApp {
    //creating one static method in the class can share the same one
    static Scanner userInput = new Scanner(System.in);

    //creating static arraylist to be used
    static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        welcomeMessage();
        homeScreen();
    }

    // method for the welcome message
    public static void welcomeMessage() {
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
            try{
                switch (userChoice) {
                    case "D" -> DepositAndPayment.addDeposit();
                    case "P" -> DepositAndPayment.makePayment();
                    case "L" -> LedgerScreen.showLedger();
                    case "X" -> {
                        System.out.println(" Closing!");
                        appRunning = false;
                    }
                    default -> System.out.println("That's not on the menu. Pick again!");
                }
            }catch (IOException e) {

                // Runs if there is an error reading the file
                System.out.println("Error opening the Ledger.");

                // Displays the error message
                System.out.println(e.getMessage());
            }

        }
    }


}



