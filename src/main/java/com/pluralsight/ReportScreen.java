package com.pluralsight;
//importing error handling, arraylist, date and time
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
//class that obtains report based on vendor or time
public class ReportScreen {
    public static void showReports() throws IOException {

        boolean reportRunning = true;

        while (reportRunning) {

            System.out.println("\n--- THE MONEY REPORT ---");
            System.out.println("1.Month to Date");
            System.out.println("2.Previous Month");
            System.out.println("3.Year to Date");
            System.out.println("4. Previous Year");
            System.out.println("5. Search by Vendor");
            System.out.println("0.  Back to Ledger");

            System.out.print("Choose an option: ");

            String choice = AccountingLedgerApp.userInput.nextLine();

            switch (choice) {

                case "1" -> ;
                case "2" ->
                case "3" ->
                case "4" ->
                case "0" -> reportRunning = false;

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
