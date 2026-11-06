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

                Transaction orderedTransaction = new Transaction(date, time, description, vendor, amount);
                parsedTransactions.add(orderedTransaction);
            }
            //closing the reader
            reader.close();
        } catch(IOException e){
            System.out.println("Unable to read the transaction file");
        }
        //returning the parsed data
        return parsedTransactions;

    }
    public static void writeTransaction(Transaction transaction)  {
        // Open the CSV file and add new information
        try{BufferedWriter writer = new BufferedWriter(
                new FileWriter("transactions.csv", true));

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

            System.out.println("Transaction saved successfully!");

        }catch(IOException e){
            System.out.println("sorry could not save the transaction ");
        }


    }

}
