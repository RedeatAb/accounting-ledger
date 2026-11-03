package com.pluralsight;

//importing local date and time
import java.time.LocalDate;
import java.time.LocalTime;

//creating transaction class that acts as blueprint for creating transactions
public class Transaction {
    // creating the data variables
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;
// creating constructors so it can create a transaction object
    public Transaction(LocalDate date, LocalTime time,
                       String description, String vendor,
                       double amount) {

        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    //adding the getters methods

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }


}



