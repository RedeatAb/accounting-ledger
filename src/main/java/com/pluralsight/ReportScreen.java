package com.pluralsight;
//importing error handling, arraylist, date and time
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

//class that obtains report based on vendor or time
public class ReportScreen {
    // This method displays the reports menu
    public static void showReports()  {

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
            try{
                switch (choice) {

                    case "1" ->monthToDate() ;
                    case "2" ->previousMonth();
                    case "3" -> yearToDate();
                    case "4" ->previousYear();
                    case "5" -> searchByVendor();
                    case "0" -> reportRunning = false;

                    default -> System.out.println("Invalid choice!");
                }

            }catch (IOException e) {

                // Displaying an error if the CSV file cannot be read
                System.out.println("Error reading transactions.");
                System.out.println(e.getMessage());
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
    // Method to display transactions from last month
    public static void previousMonth() throws IOException {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions = ReadWriteTransaction.readTransactions();

        // Getting last month's date
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        // Looping backwards through the transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {

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
    public static void yearToDate() throws IOException {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions =
                ReadWriteTransaction.readTransactions();

        // Getting today's date
        LocalDate today = LocalDate.now();

        // Looping backwards through the transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {

            // Getting one transaction from the list
            Transaction transaction = transactions.get(i);

            // Getting the date of the transaction
            LocalDate date = transaction.getDate();

            // Checking if the year matches the current year
            // Also checking that the date is not in the future
            if (date.getYear() == today.getYear()
                    && !date.isAfter(today)) {

                // Displaying the transaction
                LedgerScreen.printTransaction(transaction);
            }
        }
    }


    // Method to display transactions from last year
    public static void previousYear() throws IOException {

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions =
                ReadWriteTransaction.readTransactions();

        // Getting last year
        int lastYear = LocalDate.now().getYear() - 1;

        // Looping backwards through the transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {

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
    public static void searchByVendor() throws IOException {

        // Asking the user for a vendor name
        System.out.print("Enter vendor name: ");

        // Saving the vendor name entered by the user
        String vendor = AccountingLedgerApp.userInput.nextLine();

        // Reading all transactions from the CSV file
        ArrayList<Transaction> transactions =
                ReadWriteTransaction.readTransactions();

        // Looping backwards through the transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {

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
}
