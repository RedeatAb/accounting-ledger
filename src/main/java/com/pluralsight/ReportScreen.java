package com.pluralsight;
//importing error handling, arraylist, date and time
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

//class that obtains report based on vendor or time
public class ReportScreen {
    // This method displays the reports menu
    public static void showReports() throws IOException {

        // Keeps the reports menu running
        boolean reportRunning = true;
        // Keep showing the menu until the user exits
        while (reportRunning) {

            System.out.println("\n THE MONEY REPORT ");
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
    // Method to display transactions from this month
    public static void monthToDate() throws IOException {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Getting today's date
        LocalDate today = LocalDate.now();

        // Looping backwards to show newest transactions first
        for (int i = transactions.size() - 1; i >= 0; i--) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the date of that transaction
            LocalDate date = transaction.getDate();

            // Checking if the month and year match today's date
            // Also making sure the date is not in the future
            if (date.getMonthValue() == today.getMonthValue()
                    && date.getYear() == today.getYear()
                    && !date.isAfter(today)) {

                // Displaying the transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }
}
