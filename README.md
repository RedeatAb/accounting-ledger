# 💗 Pretty Penny

### A Simple Way to Keep Track of Your Money

Pretty Penny is a Java command-line application I created to help keep track of deposits and payments. Instead of using a complicated financial system, users can enter transactions, review their spending, and look back at their financial history through a simple menu.

## Features

- Login using a preset username and password
- Three login attempts before access is denied
- 10-second authentication delay
- Add deposits and payments
- Save transactions in a CSV file
- View transaction history
- Filter deposits and payments
- Generate monthly and yearly reports
- Search transactions by vendor
- View total deposits, payments, and current balance using Penny Snapshot
- Pink and lavender console theme

## Login System

I added a separate `LoginScreen.java` class to handle user authentication before accessing the main application.

When the program starts, the Pretty Penny welcome message appears first, followed by the login screen.

The user enters a preset username and password. The application displays an authentication message and waits 10 seconds using `Thread.sleep(10000)` before checking the credentials.

If the username and password are correct, the user can access the home screen. If the information is incorrect, the user can try again, with a maximum of three attempts.

This feature helped me practice using `Scanner`, `while` loops, `if` statements, Boolean methods, and `Thread.sleep()`.

**Note:** The preset login is intended for demonstration purposes and is not a production security system.

## How to Run

1. Download or clone this repository from GitHub.
2. Open the project in IntelliJ IDEA.
3. Make sure Java is installed and configured.
4. Locate the main Java class, `AccountingLedgerApp.java`.
5. Click the green Run button to start the application.
6. Enter the preset login credentials.
7. Follow the menu options displayed in the console.

## How Transactions Are Stored

Pretty Penny saves transactions in a file called `transactions.csv`.

Each transaction contains a date, time, description, vendor, and amount.

Example:

```csv
date|time|description|vendor|amount
2026-11-04|09:30:00|Birthday Gift Money|Bestie|250.00
2026-11-04|11:45:00|Pink Lip Gloss|Sephora|-24.50
2026-11-04|13:20:00|Shopping Spree|Zara|-89.99
2026-11-04|15:10:00|Nail Appointment|Pink Nail Studio|-55.00
```

Positive amounts represent deposits, while negative amounts represent payments.

## Penny Snapshot

I added a feature called **The Penny Snapshot** that gives users a quick overview of their finances.

It displays:

- Total deposits
- Total payments
- Current balance

This feature calculates the totals using the transactions saved in the CSV file.

## What I Learned

Building Pretty Penny helped me practice Java programming concepts such as ArrayLists, loops, methods, file reading and writing, and user input with Scanner.

I also learned how to organize my code into different classes to make the application easier to understand and maintain.

Adding the login feature helped me understand how to use Boolean methods, conditional statements, and loops to control access to an application. I also practiced using `Thread.sleep()` to create a timed authentication message.

## Built With

- Java
- IntelliJ IDEA
- CSV files
- Git and GitHub
