A Simple Way to Keep Track of Your Money

Pretty Penny is a Java command-line application I created to help keep track of deposits and payments. Instead of using a complicated financial system, users can enter transactions, review their spending, and look back at their financial history through a simple menu.

Features

Add deposits and payments

Save transactions in a CSV file

View transaction history

Filter deposits and payments

Generate monthly and yearly reports

Search transactions by vendor

How to Run

Download or clone this repository from GitHub.

Open the project in IntelliJ IDEA.

Make sure Java is installed and configured.

Locate the main Java class.

Click the green Run button to start the application.

Follow the menu options displayed in the console.

How Transactions Are Stored

Pretty Penny saves transactions in a file called transactions.csv.

Each transaction contains a date, time, description, vendor, and amount.

Example:

date|time|description|vendor|amount
2026-11-04|09:30:00|Birthday Gift Money|Bestie|250.00
2026-11-04|11:45:00|Pink Lip Gloss|Sephora|-24.50
2026-11-04|13:20:00|Shopping Spree|Zara|-89.99
2026-11-04|15:10:00|Nail Appointment|Pink Nail Studio|-55.00

Positive amounts represent deposits, while negative amounts represent payments.

What I Learned

Building Pretty Penny helped me practice Java programming concepts such as ArrayLists, loops, methods, file reading and writing, and user input with Scanner. I also learned how to organize my code into different classes to make the application easier to understand and maintain.

Built With

Java

IntelliJ IDEA

CSV files

Git and GitHub