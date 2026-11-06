package com.pluralsight;
//importing error handling, arraylist, date and time

import java.util.ArrayList;
import java.time.LocalDate;

//class that obtains report based on vendor or time
public class ReportScreen {
    // This method displays the reports menu

    public static void showReports() {

        // Keeps the reports menu running
        boolean reportRunning = true;

        // Keep showing the menu until the LoginScreen exits
        while (reportRunning) {

            // Cute decorations
            System.out.println(Colors.PALE_PINK +
                    "\n  ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡" + Colors.RESET);

            // Pink border
            System.out.println(Colors.NEON_PINK +
                    "  ╔════════════════════════════════╗");
            System.out.println("  ║                                ║");

            // Lavender title
            System.out.println(Colors.LAVENDER +
                    "  ║      ✧ THE MONEY REPORT ✧      ║");

            // Menu options
            System.out.println(Colors.NEON_PINK +
                    "  ║                                ║");

            System.out.println(Colors.PALE_PINK +
                    "  ║   1. Month to Date             ║");

            System.out.println(Colors.LAVENDER +
                    "  ║   2. Previous Month            ║");

            System.out.println(Colors.PALE_PINK +
                    "  ║   3. Year to Date              ║");

            System.out.println(Colors.LAVENDER +
                    "  ║   4. Previous Year             ║");

            System.out.println(Colors.PURPLE +
                    "  ║   5. Search by Vendor          ║");

            System.out.println(Colors.NEON_PINK +
                    "  ║                                ║");

            System.out.println(Colors.PURPLE +
                    "  ║   0. Back to Ledger            ║");

            // Closing border
            System.out.println(Colors.NEON_PINK +
                    "  ║                                ║");
            System.out.println("  ╚════════════════════════════════╝");

            // Bottom decorations
            System.out.println(Colors.PALE_PINK +
                    "  ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡ ✧ ♡" + Colors.RESET);

            // LoginScreen input
            System.out.print(Colors.NEON_PINK +
                    "\n  Choose an option: " + Colors.RESET);

            String choice = AccountingLedgerApp.userInput.nextLine();

            switch (choice) {

                case "1" -> monthToDate();
                case "2" -> previousMonth();
                case "3" -> yearToDate();
                case "4" -> previousYear();
                case "5" -> searchByVendor();
                case "0" -> reportRunning = false;

                default -> System.out.println(
                        Colors.ERROR + "Invalid choice!" + Colors.RESET
                );
            }
        }
    }


    // Method to display transactions from this month
    public static void monthToDate() {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();
        // Sort transactions from newest to oldest
        sortTransactions(transactions);

        // Getting today's date
        LocalDate today = LocalDate.now();

        printHeader();


        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

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

    // Method to display transactions from last month
    public static void previousMonth() {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Sort transactions from newest to oldest
        sortTransactions(transactions);

        // Getting last month's date
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        printHeader();


        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the transaction date
            LocalDate date = transaction.getDate();

            // Checking if the transaction is from last month
            if (date.getMonthValue() == lastMonth.getMonthValue()
                    && date.getYear() == lastMonth.getYear()) {

                // Displaying the transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }

    // Method to display transactions from this year
    public static void yearToDate() {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Sort transactions from newest to oldest
        sortTransactions(transactions);

        // Getting today's date
        LocalDate today = LocalDate.now();

        printHeader();

        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the date of the transaction
            LocalDate date = transaction.getDate();

            // Checking if the transaction is from this year
            // Also checking that the date is not in the future
            if (date.getYear() == today.getYear()
                    && !date.isAfter(today)) {

                // Displaying the transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }

    // Method to display transactions from last year
    public static void previousYear() {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Sort transactions from newest to oldest
        sortTransactions(transactions);


        // Getting last year
        int lastYear = LocalDate.now().getYear() - 1;

        printHeader();

        // Loop through the sorted transactions
        for (int i = 0; i < transactions.size(); i++) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the transaction date
            LocalDate date = transaction.getDate();

            // Checking if the transaction is from last year
            if (date.getYear() == lastYear) {

                // Displaying the transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }


    // Method to search for transactions by vendor
    public static void searchByVendor() {

        // Asking the LoginScreen for a vendor name
        System.out.print("Enter vendor name: ");

        // Saving the vendor name entered by the LoginScreen
        String vendor = AccountingLedgerApp.userInput.nextLine();

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Sort transactions from newest to oldest
        sortTransactions(transactions);

        printHeader();

        //loops through the sorted  transaction
        for (int i = 0; i < transactions.size(); i++) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the vendor name from the transaction
            String transactionVendor = transaction.getVendor();

            // Checking if the vendor names match
            if (transactionVendor.equalsIgnoreCase(vendor)) {

                // Displaying the matching transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }

    // Sort transactions from newest to oldest
    public static void sortTransactions(ArrayList<Transaction> transactions) {

        // Lambda expression (a, b) -> compares two transactions
        // a and b represent two Transaction objects
        transactions.sort((a, b) -> {

            // Compare dates, newest first
            int dateCompare = b.getDate().compareTo(a.getDate());

            // If dates are different, sort by date
            if (dateCompare != 0) {
                return dateCompare;
            }

            // If dates are the same, sort by latest time
            return b.getTime().compareTo(a.getTime());
        });
    }

    // This method displays the column names for the report
    public static void printHeader() {

        // Prints the headings in one row
        System.out.printf(
                "%-12s %-10s %-20s %-20s %10s%n",
                "DATE",
                "TIME",
                "DESCRIPTION",
                "VENDOR",
                "AMOUNT"
        );

        // Prints a line to separate headings from transactions
        System.out.println(
                "--------------------------------------------------------------------------"
        );
    }
}
