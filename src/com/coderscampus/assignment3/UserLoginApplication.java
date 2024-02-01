package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();

		User[] users;
		try {
			users = userService.readUserDataFromFile();
		} catch (IOException e) {
			System.out.println("Error reading user data from file: " + e.getMessage());
			return;
		}

		Scanner scanner = new Scanner(System.in);

		int attempts = 0;
		boolean isLoggedIn = false;

		while (attempts < 5 && !isLoggedIn) {
			System.out.println("Enter your username: ");
			String usernameInput = scanner.nextLine();
			System.out.println("Enter your password: ");
			String passwordInput = scanner.nextLine();

			boolean usernameExists = userService.usernameExists(usernameInput);
			if (!usernameExists) {
				System.out.println("Username not found.");
				attempts++;
				if (attempts < 5) {
					System.out.println("Invalid login, please try again. Attempts left: " + (5 - attempts));
				}
				continue;
			}

			boolean passwordCorrect = userService.validateUserCredentials(usernameInput, passwordInput);
			if (passwordCorrect) {
				System.out.println("Welcome, " + userService.getUserCredentials(usernameInput));
				isLoggedIn = true;
			} else {
				System.out.println("Incorrect password for the given username. Please try again.");
				attempts++;
				if (attempts < 5) {
					System.out.println("Attempts left: " + (5 - attempts));
				}
			}
		}

		if (!isLoggedIn) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}

		scanner.close();
	}

}
