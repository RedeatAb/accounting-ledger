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


    public static void main(String[] args) throws  InterruptedException{

        welcomeMessage();
        // Wait 30 seconds
        Thread.sleep(2000);

        homeScreen();

    }

    // method for the welcome message

    public static void welcomeMessage() {




            // Cute pink decorations
            System.out.print(Colors.PALE_PINK);
            System.out.println("\n  ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡");

            // Neon pink boutique border
            System.out.print(Colors.NEON_PINK);
            System.out.println("  ╔══════════════════════════════════╗");
            System.out.println("  ║                                  ║");

            // Lavender boutique name
            System.out.print(Colors.LAVENDER);
            System.out.println("  ║       ✧  PRETTY PENNY  ✧         ║");

            // Pale pink slogan
            System.out.print(Colors.PALE_PINK);
            System.out.println("  ║                                  ║");
            System.out.println("  ║    Cute outfits, cuter profits   ║");
            System.out.println("  ║                                  ║");

            // Purple tagline
            System.out.print(Colors.PURPLE);
            System.out.println("  ║       ♡  THE GLAM LIFE  ♡        ║");

            // Bottom border
            System.out.print(Colors.NEON_PINK);
            System.out.println("  ║                                  ║");
            System.out.println("  ╚══════════════════════════════════╝");

            // Matching decorations
            System.out.print(Colors.PALE_PINK);
            System.out.println("  ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡");

            System.out.print(Colors.RESET);
        }



        //method to for home screen
    public static void homeScreen() {
        boolean appRunning = true;
        // using the while loop to display the home screen
        while (appRunning) {


// Movie theater marquee lights
            System.out.print(Colors.NEON_PINK);
            System.out.println("\n   * * * * * * * * * * * * * * * * * *");
            System.out.println("   +----------------------------------+");

// Lavender movie theater title
            System.out.print(Colors.LAVENDER);
            System.out.println("   |                                  |");
            System.out.println("   |         * THE GLAM ROOM *        |");
            System.out.println("   |       NOW SHOWING: YOUR GLAM     |");
            System.out.println("   |                                  |");

// Purple menu choices
            System.out.print(Colors.PURPLE);
            System.out.println("   |   D) Treat your Wallet           |");
            System.out.println("   |      (Add Deposit)               |");
            System.out.println("   |                                  |");
            System.out.println("   |   P) Bills, Bills, Bills         |");
            System.out.println("   |      (Make Payment)              |");
            System.out.println("   |                                  |");
            System.out.println("   |   L) Spill the Tea               |");
            System.out.println("   |      (View Ledger)               |");
            System.out.println("   |                                  |");
            System.out.println("   |   X) Bye Bestie! (Exit)          |");
            System.out.println("   |                                  |");

         // Closing marquee lights
            System.out.print(Colors.NEON_PINK);
            System.out.println("   +----------------------------------+");
            System.out.println("   * * * * * * * * * * * * * * * * * *");

        // Reset colors before input
            System.out.print(Colors.RESET);
            System.out.println(Colors.PALE_PINK + "\nChoose your glam move: " + Colors.RESET);



            // string to store the user choice
            String userChoice = userInput.nextLine().trim().toUpperCase();
            //create a switch statment to direct the choices in to the desired output
            try {
                switch (userChoice) {
                    case "D" -> DepositAndPayment.addDeposit();
                    case "P" -> DepositAndPayment.makePayment();
                    case "L" -> LedgerScreen.showLedger();
                    case "X" -> {
                        System.out.println( Colors.PALE_PINK + " Closing!" + Colors.RESET );
                        appRunning = false;
                    }
                    default -> System.out.println(Colors.PALE_PINK + "That's not on the menu. Pick again!" + Colors.RESET);
                }
            } catch (IOException e) {

                // Runs if there is an error reading the file
                System.out.println("Error opening the Ledger.");

                // Displays the error message
                System.out.println(e.getMessage());
            }

        }
    }


}



