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
		System.out.println("Enter you username:");
		String usernameInput = scanner.nextLine();
		System.out.println("Enter you password:");
		String passwordInput = scanner.nextLine();

		boolean isLoggedIn = false;
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(usernameInput) && user.getPassword().equals(passwordInput)) {
				System.out.println("Welcome, " + user.getName());
				isLoggedIn = true;
				break;
			}
		}
		if (!isLoggedIn) {
			System.out.println("Invalid login, please try again.");
		}
		scanner.close();
	}
}