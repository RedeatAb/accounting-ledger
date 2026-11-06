package com.pluralsight;
//importing the reader, writer and error handling
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.File;

public class ReadWriteTransaction {
    public static ArrayList<Transaction> readTransactions() {
        //make the list inisde the method
        ArrayList<Transaction> parsedTransactions = new ArrayList<>();
        try {
            //open the file so we can read it line by line
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
            // Read the first line (the header) and skip it
            reader.readLine();
            //This line will hold one line at a time
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                // Turn each piece into the right type
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                // creating new transaction object with the parsed values
                Transaction orderedTransaction = new Transaction(date, time, description, vendor, amount);
                //added it to the new array
                parsedTransactions.add(orderedTransaction);
            }
            //closing the reader
            reader.close();
        } catch(IOException e){
            System.out.println(Colors.ERROR + "Unable to read the transaction file" + Colors.RESET);
        }
        //returning the parsed data
        return parsedTransactions;

    }
    public static void writeTransaction(Transaction transaction)  {

        // Get the CSV file
        File file = new File("transactions.csv");

        // Check if the file is new or empty
        boolean needsHeader = !file.exists() || file.length() == 0;

        try{
            // Open file to add transactions
            BufferedWriter writer = new BufferedWriter(
                new FileWriter("transactions.csv", true));

            // Add header if needed
            if (needsHeader) {
                writer.write("date|time|description|vendor|amount");
                writer.newLine();
            }

            // Create a transaction line
            String line = transaction.getDate() + "|"
                    + transaction.getTime() + "|"
                    + transaction.getDescription() + "|"
                    + transaction.getVendor() + "|"
                    + transaction.getAmount();

            // Write the transaction into the file
            writer.write(line);

            // Move to a new line
            writer.newLine();

            // Close the writer
            writer.close();

            System.out.println(Colors.GREEN + "Transaction saved successfully!"+ Colors.RESET);

        }catch(IOException e){
            System.out.println( Colors.ERROR + "sorry could not save the transaction " + Colors.RESET);
        }


    }

}
