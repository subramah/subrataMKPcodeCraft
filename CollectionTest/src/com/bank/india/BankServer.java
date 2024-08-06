package com.bank.india;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankServer {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a customer and an account
        Customer customer = new Customer("John Doe");
        Account account = new Account("A456", customer);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Display Last 10 Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter target account number for transfer: ");
                    String targetAccountNumber = scanner.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    // Assume target account exists
                    Account targetAccount = new Account(targetAccountNumber, customer);
                    account.transfer(targetAccount, transferAmount);
                    break;
                case 4:
                    account.displayLast10Transactions();
                    break;
                case 5:
                    System.out.println("Exiting the application. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
