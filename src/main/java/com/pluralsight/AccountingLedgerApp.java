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
import java.io.BufferedReader;


public class AccountingLedgerApp {
    //creating one static method in the class can share the same one
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {




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
    // create method that reads the file
    public static void readTransactions() throws IOException{
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

        }
        reader.close();

    }


}



