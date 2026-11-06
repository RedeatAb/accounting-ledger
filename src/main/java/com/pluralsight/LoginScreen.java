package com.pluralsight;

import java.util.Scanner;

public class LoginScreen {

    // Scanner to collect username and password
    static Scanner loginInput = new Scanner(System.in);

    public static boolean login()throws  InterruptedException {


        // Preset username and password
        String username = "Rae";
        String password = "StarGirl101";

        // Count how many times the user tries to log in
        int attempts = 0;

        // Allow the user to try logging in 3 times
        while (attempts < 3) {

            // Display login title
            System.out.println(Colors.NEON_PINK +
                    "\n♡ ✧ PRETTY PENNY LOGIN ✧ ♡" + Colors.RESET);

            // Ask for username
            System.out.print(Colors.LAVENDER + "Username: " + Colors.RESET);
            String enteredUsername = loginInput.nextLine();

            // Ask for password
            System.out.print(Colors.LAVENDER + "Password: " + Colors.RESET);
            String enteredPassword = loginInput.nextLine().trim();
            // Display authentication message
            System.out.println(Colors.LAVENDER +
                    "♡ Authenticating... Please wait ♡" + Colors.RESET);

            // Wait 10 seconds before checking login credentials
            Thread.sleep(10000);

            // Check if username and password match
            if (enteredUsername.equals(username) &&
                    enteredPassword.equals(password)) {

                // Return true if login is successful
                System.out.println(Colors.GREEN +
                        "♡ Login successful! " + Colors.RESET);
                //return
                return true;
            }

            // Increase attempts after an incorrect login
            attempts++;

            // Show how many attempts are left
            System.out.println(Colors.ERROR +
                    "Oops bestie! Incorrect login. Attempts left: "
                    + (3 - attempts) + Colors.RESET);
        }

        // Display message after 3 failed attempts
        System.out.println(Colors.ERROR +
                "Too many attempts! Access denied." + Colors.RESET);

        // Return false if login fails
        return false;
    }


}
